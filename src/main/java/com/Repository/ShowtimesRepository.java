package com.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.view.ShowtimePeriodDTO;
import com.Entity.Employee;
import com.Entity.Movie;
import com.Entity.Period;
import com.Entity.Showtimes;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {

	@Query("FROM Showtimes s WHERE s.status = :status")
	List<Showtimes> findShowtimesByStatus(Integer status);

	@Query("FROM  Showtimes s WHERE s.showtimeId = :id AND s.status = 1")
	Optional<Showtimes> findByShowtimesId(Integer id);
	
	@Query(value ="SELECT s "
			+ "FROM Showtimes s "
			+ "WHERE s.date = :date AND  s.room.roomId = :roomId AND s.period.periodId = :periodId")
	Optional<Showtimes> findShowtimeByRoomPeriodDate(Date date, Integer periodId, Integer roomId);

	@Query(value = "SELECT s.room.cinema.cinemaId FROM Showtimes s WHERE s.movie.movieId = :movieId AND s.status = 1 GROUP BY s.room.cinema.cinemaId ")
	List<Integer> findCinemaByMovieId(Integer movieId);

	@Query(value = "SELECT s.date FROM Showtimes s WHERE s.movie.movieId = :movieId AND s.room.cinema.cinemaId = :cinemaId AND s.status = 1 GROUP BY s.date ")
	List<Date> findDateByCinemaMovie(Integer cinemaId, Integer movieId);

	@Query(value = "SELECT s.room.roomId FROM Showtimes s WHERE s.movie.movieId = :movieId AND s.room.cinema.cinemaId = :cinemaId AND s.status = 1 AND s.date = :date GROUP BY s.room.roomId")
	List<Integer> findRoomByCinemaMovieDate(Integer cinemaId, Integer movieId, Date date);
	
	@Query(value = "SELECT s FROM Showtimes s WHERE s.movie.movieId = :movieId AND s.room.cinema.cinemaId = :cinemaId AND s.date = :date AND s.status = 1 AND s.room.roomId = :roomId")
	List<Showtimes> findPeriod(Integer cinemaId, Integer movieId, Date date, Integer roomId);

	@Query(value ="SELECT s "
			+ "FROM Showtimes s "
			+ "WHERE s.date BETWEEN :startDate AND :endDate ")
	List<Showtimes> findShowtimeByNextDate(Date startDate, Date endDate);
	
	@Query(value = "SELECT s "
			+ "FROM Showtimes s "
			+ "WHERE s.room.cinema.cinemaId = :id ")
	List<Showtimes> getShowtimesByCinema(Integer id);
	
	@Query(value = "SELECT s FROM Showtimes s WHERE s.movie.movieName like %:name% AND s.status = :status")
	List<Showtimes> getShowtimesByMovieName(String name, Integer status);
	
	
	
}
