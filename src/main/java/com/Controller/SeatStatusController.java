package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.CinemaDTO;
import com.DTO.Base.ResponseEntity;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
import com.Entity.SeatStatus;
import com.Services.CinemaService;
import com.Services.SeatStatusService;

@RestController
@RequestMapping(value = "seatstatus")

public class SeatStatusController {

	@Autowired
	private SeatStatusService seatStatusService;

	@GetMapping("/findbyshowtimeid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<SeatStatus> listSeatStatus = seatStatusService.findAllByShowtimeId(id);
			if (listSeatStatus.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listSeatStatus);
			}
		}
	}
}
