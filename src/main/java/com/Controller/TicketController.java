package com.Controller;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.FoodBillDetailDTO;
import com.DTO.SeatDTO;
import com.DTO.SeatStatusDTO;
import com.DTO.TicketDTO;
import com.Entity.Food;
import com.Entity.FoodBillDetail;
import com.Entity.Member;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.Services.EmailService;
import com.Services.FoodBillDetailService;
import com.Services.FoodService;
import com.Services.MemberService;
import com.Services.QRCodeService;
import com.Services.SeatService;
import com.Services.SeatStatusService;
import com.Services.TicketDetailService;
import com.Services.TicketService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "ticket")

public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private TicketDetailService ticketDetailService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodBillDetailService foodBillDetailService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SeatStatusService seatStatusService;
	@Autowired
	private EmailService emailService;
	@Autowired
	QRCodeService qRCodeService;

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/images/";

	@GetMapping
	public ResponseEntity<List<Ticket>> index() {
		return ResponseEntity.body(ticketService.getAll());
	}

	@PostMapping(value = "/checkticket")
	public ResponseEntity<Object> checkTicket(@RequestBody TicketDTO ticketDTO){
		Ticket ticket = ticketService.converToTicket(ticketDTO);
		double totalTicket = ticket.getShowtimes().getPeriod().getPrice() * ticket.getTicketQuantity();
		double totalFood = 0;
		List<FoodBillDetailDTO> listFoodBillDTO = ticketDTO.getListFoodBillDetail();
		if (listFoodBillDTO != null) {
			for (FoodBillDetailDTO foodBillDetail : listFoodBillDTO) {
				Food food = foodService.findById(foodBillDetail.getFoodId()).orElse(null);
				totalFood += food.getPrice() * foodBillDetail.getQuantity();
			}
		}
		double total = totalTicket + totalFood;
		List<SeatStatusDTO> listSeatStatusDTO = ticketDTO.getListSeatStatus();
		for (SeatStatusDTO seatStatusDTO : listSeatStatusDTO) {
			SeatStatus seatStatus = seatStatusService.findById(seatStatusDTO.getSeatStatusId()).orElse(null);
			if (seatStatus.getStatus() == true) {
				return ResponseEntity.body(Constant.Exception.MESSAGE);
			}
		}
		return  ResponseEntity.body(total);
	}
	
	@PostMapping(value = "/book")
	public ResponseEntity<Object> bookTicket(@RequestBody TicketDTO ticketDTO) throws Exception {
		if (ticketDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			ticketDTO.setTicketId(null);
			Ticket ticket = ticketService.converToTicket(ticketDTO);
			
			List<SeatStatusDTO> listSeatStatusDTO = ticketDTO.getListSeatStatus();
			for (SeatStatusDTO seatStatusDTO : listSeatStatusDTO) {
				SeatStatus seatStatus = seatStatusService.findById(seatStatusDTO.getSeatStatusId()).orElse(null);
				if (seatStatus.getStatus() == true) {
					return ResponseEntity.body(Constant.Exception.MESSAGE);
				}
			}
			
			double totalTicket = ticket.getShowtimes().getPeriod().getPrice() * ticket.getTicketQuantity();
			double totalFood = 0;
			List<FoodBillDetailDTO> listFoodBillDTO = ticketDTO.getListFoodBillDetail();
			if (listFoodBillDTO != null) {
				for (FoodBillDetailDTO foodBillDetail : listFoodBillDTO) {
					Food food = foodService.findById(foodBillDetail.getFoodId()).orElse(null);
					totalFood += food.getPrice() * foodBillDetail.getQuantity();
				}
			}
			
			double total = totalTicket + totalFood;
			ticket.setTicketPriceAmount(totalTicket);
			ticket.setTotal(total);
			
			ticket = ticketService.save(ticket);
			String code = ticketService.createCode(ticket.getTicketId(), ticket.getShowtimes().getShowtimeId());
			ticket.setCode(code);
			ticket = ticketService.save(ticket);

			List<SeatDTO> listSeat = ticketDTO.getListSeat();
			List<FoodBillDetailDTO> listFoodBillDetailDTO = ticketDTO.getListFoodBillDetail();

			for (SeatDTO seatDTO : listSeat) {
				Seat seat = seatService.findById(seatDTO.getSeatId()).orElse(null);
				TicketDetail ticketDetail = new TicketDetail();
				ticketDetail.setTicket(ticket);
				ticketDetail.setSeat(seat);
				ticketDetailService.save(ticketDetail);
			}

			for (FoodBillDetailDTO foodsDto : listFoodBillDetailDTO) {
				Food food = foodService.findById(foodsDto.getFoodId()).orElse(null);
				FoodBillDetail foodBillDetail = new FoodBillDetail();
				foodBillDetail.setTicket(ticket);
				foodBillDetail.setFood(food);
				foodBillDetail.setQuantity(foodsDto.getQuantity());
				foodBillDetail.setTotal(foodsDto.getTotal());
				foodBillDetailService.save(foodBillDetail);
			}

			for (SeatStatusDTO seatStatusDTO : listSeatStatusDTO) {
				SeatStatus seatStatus = seatStatusService.findById(seatStatusDTO.getSeatStatusId()).orElse(null);
				seatStatus.setStatus(true);
				seatStatusService.save(seatStatus);
			}

			Member member = new Member();
			member = memberService.findById(ticket.getMember().getMemberId()).orElse(null);
			Double totalMoney = ticket.getTotal() + member.getTotalMoney();
			member.setTotalMoney(totalMoney);
			member = memberService.save(member);

			ticket = ticketService.findById(ticket.getTicketId()).orElse(null);

			System.out.println(ticket.getCode());
			String filePath = QR_CODE_IMAGE_PATH + ticket.getTicketId() + ".png";
			qRCodeService.generateQRCodeImage(ticket.getCode(), 200, 200, filePath);
			emailService.sendMail(member.getUser().getEmail(), "Đặt vé thành công", null,
					emailService.setTextTicket(ticket, filePath));

			return ResponseEntity.body(ticket);
		}
	}

	@GetMapping("/getticketbycinema")
	public ResponseEntity<Object> getTicketByCinema(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Ticket> listTicket = ticketService.getTicketByCinema(id);
			return ResponseEntity.body(listTicket);
		}
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> getTicketByMemberName(Integer id, String name) {
		if (id == null || name == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Ticket> listTicket = ticketService.getTicketByName(id, name);
			return ResponseEntity.body(listTicket);
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Ticket> optionalTicket = ticketService.findById(id);
			if (optionalTicket.isPresent()) {
				Ticket ticket = optionalTicket.orElse(null);
				return ResponseEntity.body(ticket);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}
	
	@GetMapping("/findfoodbyid")
	public ResponseEntity<Object> findFoodById(Integer ticketId) {
		if (ticketId == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<FoodBillDetail> list = foodBillDetailService.getFoodBillDetailByTicketId(ticketId);
			if (!list.isEmpty()) {
				return ResponseEntity.body(list);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}
}