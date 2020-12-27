package com.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.Base.ResponseEntity;
import com.DTO.view.CinemaShowtimeViewDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.HistoryTransViewDTO;
import com.DTO.view.TopMovieView;
import com.DTO.view.StartTimeView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.DTO.view.TotalMemberFeedbackMovieTicket;
import com.Entity.TicketDetail;
import com.Services.FoodBillDetailService;
import com.Services.PeriodService;
import com.Services.TicketDetailService;
import com.Services.TicketService;
import com.Services.ViewService;

@RestController
@RequestMapping(value = "view")

public class ViewController {

	@Autowired
	private ViewService viewService;
	@Autowired
	private TicketService ticketService;

	@GetMapping("/ticketofmonth")
	// tổng vé theo phim (theo tháng)
	public ResponseEntity<List<TicketByMovieView>> getTicketOfMonthByMovie(Integer month) {
		return ResponseEntity.body(viewService.getTicketOfMonthByMovie(month));
	}

	@GetMapping("/ticketbymovie/{status}")
	// tổng vé theo phim, tìm theo status 1 : đang chiếu, 2 sắp chiếu, 3 ngừng chiếu
	public List<TicketByMovieView> getTicketByMovie(@PathVariable("status") Integer status) {
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return viewService.getTicketByMovie(st);
	}

	@GetMapping("/ticketbyshowtime")
	public ResponseEntity<List<TicketByShowtimeView>> getTicketByShowtime(Integer id) {
		return ResponseEntity.body(viewService.getTicketByShowtime(id));
	}

	@GetMapping("/totalofmonth")
	// tổng tiền của các rạp theo tháng
	public ResponseEntity<List<TotalByCinemaView>> getTotalOfMonthByCinema(Integer id) {
		return ResponseEntity.body(viewService.getTotalOfMonthByCinema(id));
	}

	@GetMapping("/totalbycinema")
	// tổng tiền của rạp
	public List<TotalByCinemaView> getTotalByCinema() {
		return viewService.getTotalByCinema();
	}

	@GetMapping("/findgenre")
	public ResponseEntity<List<GenreMovieView>> getGenreByMovieId(Integer id) {
		return ResponseEntity.body(viewService.getGenreByMovieId(id));
	}

	@GetMapping("/historytrans")
	// lịch sử giao dịch ( tất cả thông tin của vé) theo memberId :
	// /historytrans?id=???
	public ResponseEntity<List<HistoryTransViewDTO>> getHistoryTransaction(Integer id) {
		List<HistoryTransView> list = viewService.getTicketBought(id);
		List<HistoryTransViewDTO> listDTO = new ArrayList<>();
		for (HistoryTransView historyTransView : list) {
			HistoryTransViewDTO dto = new HistoryTransViewDTO();
			dto = viewService.convertToDtos(historyTransView);
			List<String> listSeat = new ArrayList<>();
			List<TicketDetail> listTicketDetail = ticketService.findById(historyTransView.getticketId()).get()
					.getTicketDetail();
			for (TicketDetail ticketDetail : listTicketDetail) {
				listSeat.add(ticketDetail.getSeat().getSeatName());
			}
			dto.setSeats(listSeat);
			listDTO.add(dto);
		}
		return ResponseEntity.body(listDTO);
	}

	// Lấy số lượng member, feedback, movie, ticket
	@GetMapping("/findcount")
	public ResponseEntity<TotalMemberFeedbackMovieTicket> getTotalMemberFeedbackMovieTicket() {
		return ResponseEntity.body(viewService.getTotalMemberFeedbackMovieTicket());
	}

	@GetMapping("/cinemaShowtimeView")
	public ResponseEntity<List<CinemaShowtimeViewDTO>> getCinemaShowtimeView() {
		return ResponseEntity.body(viewService.getCinemaShowtimeView());
	}

}