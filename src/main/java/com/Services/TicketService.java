package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DTO.TicketDTO;
import com.DTO.view.ShowtimesMovieDTO;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.Entity.Ticket;
import com.Entity.TicketDetail;

@Service
public interface TicketService {
	/**
	 * Find all entity Ticket
	 * 
	 * @return List<Ticket>
	 */
	List<Ticket> getAll();

	/**
	 * Saves a entity Ticket
	 * 
	 * @return Ticket
	 */
	Ticket add(Ticket ticket);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Ticket
	 */
	Ticket save(Ticket ticket);

	/**
	 * Search an entity Ticket by Ticket's code
	 * 
	 * @return entity Ticket
	 */
	Ticket findTicketByCode(String code);

	/**
	 * Search an entity Ticket by its id
	 * 
	 * @return the entity with the ticketId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Ticket> findById(Integer id);

	/**
	 * Convert from EmployeeDTO to entity Employee
	 * 
	 * @return entity Employee
	 */
	Ticket converToTicket(TicketDTO ticketDTO);

	/**
	 * The function that auto generate Ticket's code by hashed ticketId and showtimeId
	 *
	 * @return String
	 */
	String createCode(Integer ticketId, Integer showtimeId);
	/**
	 * The function that get entity Ticket by id of entity Cinema
	 *
	 * @return List<Ticket>
	 */
	List<Ticket> getTicketByCinema(Integer cinemaId);
	/**
	 * The function that get entity Ticket by memberName of entity Member
	 *
	 * @return List<Ticket>
	 */
	List<Ticket> getTicketByName(Integer id,String name);
	
}
