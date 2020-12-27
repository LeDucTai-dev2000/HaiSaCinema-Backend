package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.TicketDetail;
import com.Repository.TicketDetailRepository;
import com.Services.TicketDetailService;

@Service
public class TicketDetailServiceImpl implements TicketDetailService {
	@Autowired
	TicketDetailRepository repository;
	

	@Override
	public TicketDetail add(TicketDetail ticketDetail) {
		return repository.save(ticketDetail);
	}

	@Override
	public TicketDetail save(TicketDetail ticketDetail) {
		return repository.saveAndFlush(ticketDetail);
	}

}
