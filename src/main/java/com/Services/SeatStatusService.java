package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Service
public interface SeatStatusService {

	Showtimes add(Showtimes showtimes);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity SeatStatus
	 */
	SeatStatus save(SeatStatus seatStatus);

	/**
	 * Search an entity SeatStatus by its id
	 * 
	 * @return the entity with the SeatStatusId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<SeatStatus> findById(Integer seatStatusId);

	/**
	 * Find all entity SeatStatus by showtimeId entered
	 * 
	 * @return List<SeatStatus>
	 */
	List<SeatStatus> findAllByShowtimeId(Integer showtimeId);
}
