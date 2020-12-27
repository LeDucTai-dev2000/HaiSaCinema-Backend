package com.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.FoodBillDetail;
import com.Repository.FoodBillDetailRepository;
import com.Services.FoodBillDetailService;

@Service
public class FoodBillDetailServiceImpl implements FoodBillDetailService {
	@Autowired
	FoodBillDetailRepository repository;

	@Override
	public FoodBillDetail add(FoodBillDetail foodBillDetail) {
		return repository.save(foodBillDetail);
	}

	@Override
	public FoodBillDetail save(FoodBillDetail foodBillDetail) {
		return repository.saveAndFlush(foodBillDetail);
	}

	@Override
	public Double getTotalFood(Integer ticketId) {
		return repository.getTotalFood(ticketId);
	}

	@Override
	public List<FoodBillDetail> getFoodBillDetailByTicketId(Integer ticketId) {
		return repository.findByTicketTicketId(ticketId);
	}

}
