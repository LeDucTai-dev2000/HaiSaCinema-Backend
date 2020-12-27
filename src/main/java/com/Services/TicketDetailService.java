package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.TicketDetail;

@Service
public interface TicketDetailService {
	/**
	 * Saves a entity TicketDetail
	 * 
	 * @return TicketDetail
	 */
	TicketDetail add(TicketDetail ticketDetail);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity TicketDetail
	 */
	TicketDetail save(TicketDetail ticketDetail);

}
