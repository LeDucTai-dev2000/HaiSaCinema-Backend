package com.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.ShowtimesDTO;
import com.DTO.view.ShowtimePeriodDTO;
import com.DTO.view.ShowtimesMovieDTO;
import com.Entity.Employee;
import com.Entity.Period;
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {
	/**
	 * Find all entity Showtimes
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> getAllShowtimes();

	/**
	 * Delete all entity Showtimes already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves an entity Showtimes
	 * 
	 * @return entity Showtimes
	 */
	Showtimes add(Showtimes showtimes);
	
	/**
	 * Find an entity Showtimes by Date and PeriodId and RoomId
	 * 
	 *@return the entity with the ShowtimesId entered or Optional#empty() if none found
	 */
	Optional<Showtimes>  findShowtimeByRoomPeriodDate(Date date, Integer periodId, Integer roomId);

	/**
	 * Saves all entity Showtimes from list showtimes
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> addAll(List<Showtimes> list);

	/**
	 * Search an entity Showtimes by its id
	 * 
	 * @return the entity with the ShowtimesId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Showtimes> findById(Integer id);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Showtimes
	 */
	Showtimes save(Showtimes showtimes);

	/**
	 * Find all entity Showtimes by status(present or unpresent) entered
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> findShowtimesByStatus(Integer status);

	/**
	 * Convert from ShowtimesDTO to entity Showtimes
	 * 
	 * @return entity Showtimes
	 */
	Showtimes convert(ShowtimesDTO dto);

	List<ShowtimesMovieDTO> listShowtime(Integer movieId);

	/**
	 * The function that will update status of entity Showtimes after a schedule
	 * 
	 * @return void
	 */
	void updateShowtimeByPreviousDate();

	/**
	 * Find all entity Showtimes by cinemaId of entity Showtimes
	 * 
	 * @param cinemaId of entity Showtimes
	 * @return List<Showtimes>
	 */
	List<Showtimes> getShowtimesByCinema(Integer id);


	/**
	 * Find all entity Showtimes by Movie name of entity Showtimes
	 * 
	 * @param cinemaId of entity Showtimes
	 * @return List<Showtimes>
	 */
	List<Showtimes> getShowtimesByMovieName(String name, Integer status);

}
