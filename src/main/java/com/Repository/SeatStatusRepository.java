package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatus, Integer> {
	List<SeatStatus> findByShowtimes(Showtimes showtimes);
}
