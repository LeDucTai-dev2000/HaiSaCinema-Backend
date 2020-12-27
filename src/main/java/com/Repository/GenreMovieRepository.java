package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Entity.GenreMovie;

public interface GenreMovieRepository extends JpaRepository<GenreMovie, Integer> {

	@Query("FROM GenreMovie g WHERE g.genreId = :id")
	Optional<GenreMovie> findById(Integer id);

	@Query(value = "SELECT g FROM GenreMovie g WHERE g.name LIKE %:name% ")
	List<GenreMovie> findByName(String name);
	
}
