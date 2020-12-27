package com.Controller;

import com.Entity.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.PeriodDTO;
import com.DTO.Base.ResponseEntity;
import com.Services.PeriodService;

@RestController
@RequestMapping(value = "period")
public class PeriodController {

	@Autowired
	PeriodService periodService;

	@GetMapping
	public ResponseEntity<List<Period>> index() {
		return ResponseEntity.body(periodService.getAll());

	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addPeriod(@RequestBody PeriodDTO periodDTO) {
		if (periodDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			// Make sure id is NULL to insert Entity
			periodDTO.setPeriodId(null);
			;
			Period period = periodDTO.convertToPeriod();
			return ResponseEntity.body(periodService.add(period));
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updatePeriod(@RequestBody PeriodDTO periodDTO) {
		if (periodDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Period> checkPeriod = periodService.findById(periodDTO.getPeriodId());
			if (checkPeriod.isPresent()) {
				Period period = periodDTO.convertToPeriod();
				return ResponseEntity.body(periodService.save(period));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbystatus")
	public ResponseEntity<Object> findPeriodByStatus(Integer status) {
		if (status == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Period> listPeriod = periodService.findPeriodByStatus(status);
			if (listPeriod.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listPeriod);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findPeriodById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Period> optionalPeriod = periodService.findById(id);
			if (optionalPeriod.isPresent()) {
				Period period = optionalPeriod.orElse(null);
				return ResponseEntity.body(period);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}
}
