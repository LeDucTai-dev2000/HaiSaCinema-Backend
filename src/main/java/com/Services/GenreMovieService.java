package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.GenreMovie;

@Service
public interface GenreMovieService {
	/**
	 * Find all entity GenreMovie
	 * 
	 * @return List<GenreMovie>
	 */
	List<GenreMovie> getAll();

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity GenreMovie
	 */
	GenreMovie save(GenreMovie genre);

	/**
	 * Search an entity GenreMovie by its id
	 * 
	 * @return the entity with the GenreMovieId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<GenreMovie> findById(Integer id);

	/**
	 * Search list GenreMovie with the same name(genreName) entered
	 * 
	 * @return List<GenreMovie>
	 */
	List<GenreMovie> findByName(String name);

	/**
	 * Saves a entity GenreMovie
	 * 
	 * @return entity GenreMovie
	 */
	GenreMovie add(GenreMovie genre);

}
