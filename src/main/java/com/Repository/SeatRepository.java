package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
	
	@Query("FROM Seat s WHERE s.seatId = :id ")
	Optional<Seat> findBySeatId(Integer id);

	@Query("FROM Seat s WHERE s.seatName LIKE %:name%")
	List<Seat> findBySeatName(String name);
}
