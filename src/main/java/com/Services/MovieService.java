package com.Services;

import com.Entity.Movie;
import com.Entity.Showtimes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
	/**
	 * Find all entity Movie
	 * 
	 * @return List<Movie>
	 */
	List<Movie> getAll();

	/**
	 * Saves an entity Movie
	 * 
	 * @return entity Movie
	 */
	Movie add(Movie movie);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Movie
	 */
	Movie save(Movie movie);

	/**
	 * Delete all entity Movie already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves all entity Movie from list Movie
	 * 
	 * @return List<Movie>
	 */
	List<Movie> addAll(List<Movie> list);

	/**
	 * Find all entity Movie with status entered(showing,stop showing,coming)
	 * 
	 * @return List<Movie>
	 */
	List<Movie> findMovieByStatus(Integer status);

	/**
	 * Search an entity Movie by its id
	 * 
	 * @return the entity with the EmployeeId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Movie> findById(Integer id);

	/**
	 * Find all entity Movie with the same name(movieName) and with status entered
	 * 
	 * @return List<Movie>
	 */
	List<Movie> findByName(String name, Integer status);

	/**
	 * The function that will update status of entity Movie after a schedule
	 * 
	 * @return void
	 */
	void updateMovieStatus();
	/**
	 * Find all entity Movie with the same name(movieName)
	 * 
	 * @return List<Movie>
	 */
	List<Movie> findByMovieName(String name);
}
