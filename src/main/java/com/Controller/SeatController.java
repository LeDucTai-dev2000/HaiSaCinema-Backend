package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.SeatDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Seat;
import com.Services.SeatService;

@RestController
@RequestMapping(value = "/seat")

public class SeatController {

	@Autowired
	SeatService seatService;
	
	@GetMapping
	public ResponseEntity<List<Seat>> index(){
		return ResponseEntity.body(seatService.findAll());
	}
	@PostMapping("/add")
	public ResponseEntity<Object> addSeat(@RequestBody SeatDTO seatDTO){
		if(seatDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		}else {
			seatDTO.setSeatId(null);
			Seat seat  = seatDTO.convertToDTO();
			return ResponseEntity.body(seatService.save(seat));
		}
	}
}
