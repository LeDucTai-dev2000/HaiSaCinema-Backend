package com.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.FoodBillDetail;

@Repository
public interface FoodBillDetailRepository extends JpaRepository<FoodBillDetail, Integer> {
	@Query(value = "SELECT SUM(f.total) "
			+ "FROM FoodBillDetail f "
			+ "WHERE f.ticket.ticketId = :id")
	Double getTotalFood(Integer id);
	
	List<FoodBillDetail> findAllByTicketTicketId(Integer id);
	
	List<FoodBillDetail> findByTicketTicketId(Integer ticketId);
	
}
