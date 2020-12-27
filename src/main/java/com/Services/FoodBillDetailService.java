package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Entity.FoodBillDetail;

@Service
public interface FoodBillDetailService {
	/**
	 * Saves a FoodBillDetail entity.
	 * 
	 * @return entity FoodBillDetail
	 */
	FoodBillDetail add(FoodBillDetail foodBillDetail);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity FoodBillDetail
	 */
	FoodBillDetail save(FoodBillDetail foodBillDetail);
	
	/**
	 * Get total money of food by Ticket's id
	 * 
	 * @return entity FoodBillDetail
	 */
	Double getTotalFood(Integer ticketId);
	
	/**
	 * Get list foodBillDetail  by Ticket's id
	 * 
	 * @return list entity FoodBillDetail
	 */
	List<FoodBillDetail> getFoodBillDetailByTicketId(Integer ticketId);
	
}
