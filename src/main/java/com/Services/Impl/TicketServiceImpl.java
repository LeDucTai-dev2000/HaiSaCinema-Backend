package com.Services.Impl;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.TicketDTO;
import com.Entity.Member;
import com.Entity.Showtimes;
import com.Entity.Ticket;
import com.Repository.MemberRepository;
import com.Repository.ShowtimesRepository;
import com.Repository.TicketRepository;
import com.Services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository repository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ShowtimesRepository showtimesRepository;

	@Override
	public Ticket add(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket findTicketByCode(String code) {
		return repository.findTicketByCode(code);
	}

	@Override
	public Ticket converToTicket(TicketDTO ticketDTO) {
		Showtimes showtimes = showtimesRepository.findById(ticketDTO.getShowtimeId()).orElse(null);
		Member member = memberRepository.findById(ticketDTO.getMemberId()).orElse(null);
		Date date = new Date();
		Ticket ticket = new Ticket();
		ticket.setDate(date);
		ticket.setShowtimes(showtimes);
		ticket.setMember(member);
		ticket.setTicketQuantity(ticketDTO.getTicketQuantity());
		ticket.setTicketPriceAmount(ticketDTO.getTicketPriceAmount());
		ticket.setCode(ticketDTO.getCode());
		ticket.setTotal(ticketDTO.getTotal());
		return ticket;
	}

	@Override
	public Optional<Ticket> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Ticket> getAll() {
		return repository.findAll();
	}

	@Override
	public String createCode(Integer ticketId, Integer showtimeId) {
		String ticketIdString = String.valueOf(ticketId);
		String showtimeIdString = String.valueOf(showtimeId);
		String totalIdString = ticketIdString + showtimeIdString;
		System.out.println(totalIdString);

		String encodedString1 = Base64.getEncoder().withoutPadding().encodeToString(ticketIdString.getBytes());
		String encodedString2 = Base64.getEncoder().withoutPadding().encodeToString(showtimeIdString.getBytes());
		String encodedString = encodedString1 + encodedString2;
		String random = "";
		
		if (totalIdString.length() < 10) {
			int count = 15 - totalIdString.length();
			for (int i = 0; i < count; i++) {
				int random_int = (int) (Math.random() * (9 - 0 + 1) + 0);
				random = random + String.valueOf(random_int);
			}
		}
		
		String encodedString3 = Base64.getEncoder().withoutPadding().encodeToString(random.getBytes());
		encodedString = encodedString + encodedString3;

		return encodedString;
	}

	@Override
	public List<Ticket> getTicketByCinema(Integer cinemaId) {
		return repository.getTicketByCinema(cinemaId);
	}

	@Override
	public List<Ticket> getTicketByName(Integer id, String name) {
		return repository.getTicketByName(id,name);
	}
	

	

}
