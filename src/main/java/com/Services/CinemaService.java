package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Entity.Cinema;

@Service
public interface CinemaService {
	/**
	 * The function that get all of the Cinema already exist
	 * 
	 * @return List<Cinema>
	 */
	List<Cinema> getAll();

	/**
	 * Convert from CinemaDTO to entity Cinema by ObjectMapper
	 * 
	 * @return entity Cinema
	 */
	Cinema convertToCinema();

	/**
	 * Delete all column from table Cinema
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves a Cinema entity.
	 * 
	 * @return entity Cinema
	 */
	Cinema add(Cinema cinema);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Cinema
	 */
	Cinema save(Cinema cinema);


	/**
	 * Search a entity Cinema by its id
	 * 
	 * @return the entity with the CineamId entered or Optional#empty() if none
	 *         found.
	 */
	List<Cinema> addAll(List<Cinema> list);

	/**
	 * This is function find Cinema by CinemaId
	 * 
	 * @return Optional Cinema
	 */
	Optional<Cinema> findById(Integer id);

	/**
	 * Search list Cinema with the same name(cinemaName) entered
	 * 
	 * @return List<Cinema>
	 */
	List<Cinema> findByName(String name);

}
