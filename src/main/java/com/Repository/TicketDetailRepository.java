package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Seat;
import com.Entity.TicketDetail;

@Repository
public interface TicketDetailRepository extends JpaRepository<TicketDetail, Integer> {

	@Query(value = "SELECT t.seat.seatName FROM TicketDetail t WHERE t.ticketDetailId = :id")
	String findByTicketDetailId(Integer id);

	List<TicketDetail> findAllByTicketTicketId(Integer id);
}
