package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Seat;

@Service
public interface SeatService {
	/**
	 * Find all entity Seat
	 * 
	 * @return List<Seat>
	 */
	List<Seat> getAll(Integer status);

	/**
	 * Find all entity Seat
	 * 
	 * @return List<Seat>
	 */
	List<Seat> findAll();

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Seat
	 */
	Seat save(Seat seat);

	/**
	 * Search list Seat with the same name(seatName) entered
	 * 
	 * @return List<Seat>
	 */
	List<Seat> findByName(String name);

	/**
	 * Search an entity Seat by its id
	 * 
	 * @return the entity with the SeatId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Seat> findById(Integer id);
}
