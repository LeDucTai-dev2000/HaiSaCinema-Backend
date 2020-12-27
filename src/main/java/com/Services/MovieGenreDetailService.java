package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Entity.MovieGenreDetail;

@Service
public interface MovieGenreDetailService {
	/**
	 * Saves a entity MovieGenreDetail
	 * 
	 * @return MovieGenreDetail
	 */
	MovieGenreDetail add(MovieGenreDetail movieGenreDetail);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity MovieGenreDetail
	 */
	MovieGenreDetail save(MovieGenreDetail movieGenreDetail);

	/**
	 * Search an entity Employee by its id
	 * 
	 * @return the entity with the MovieGenreDetailId entered or Optional#empty() if
	 *         none found.
	 */
	Optional<MovieGenreDetail> findById(Integer id);

	/**
	 * Delete all entity MovieGenreDetail where exists movieId entered
	 * 
	 * @return void
	 */
	void deleteByMovieId(Integer movieId);

	/**
	 * Find all entity MovieGenreDetail where exists movieId entered.
	 * 
	 * @return List<MovieGenreDetail>
	 */
	List<MovieGenreDetail> findAllByMovieId(Integer movieId);

	/**
	 * Find all entity MovieGenreDetail where exists genreId entered.
	 * 
	 * @return List<MovieGenreDetail>
	 */
	List<MovieGenreDetail> findAllByGenre(Integer genreId);
}
