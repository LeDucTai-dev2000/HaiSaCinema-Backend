package com.Repository;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.MovieGenreDetail;

@Repository
public interface MovieGenreDetailRepository extends JpaRepository<MovieGenreDetail, Integer> {
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MovieGenreDetail m WHERE m.movie.movieId = :movieId ")
	void deleteByMovieId(Integer movieId);
	

	List<MovieGenreDetail> findAllByMovieMovieId(Integer id);
	
	@Query(value = "SELECT m FROM MovieGenreDetail m WHERE m.genreMovie.genreId = :id")
	List<MovieGenreDetail> findAllByGenre(Integer id);
	
}
