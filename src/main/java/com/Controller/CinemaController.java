package com.Controller;

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
import com.DTO.CinemaDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Cinema;
import com.Services.CinemaService;

@RestController
@RequestMapping(value = "cinema")
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	
	@GetMapping
	public ResponseEntity<List<Cinema>> index() {
		return ResponseEntity.body(cinemaService.getAll());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addCinema(@RequestBody CinemaDTO cinemaDTO) {
		if (cinemaDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			cinemaDTO.setCinemaId(null);
			Cinema cinema = cinemaService.convertToCinema();
			return ResponseEntity.body(cinemaService.add(cinema));
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateCinema(@RequestBody CinemaDTO cinemaDTO) {
		if (cinemaDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Cinema> checkCinema = cinemaService.findById(cinemaDTO.getCinemaId());
			if (checkCinema.isPresent()) {
				Cinema cinema = cinemaService.convertToCinema();
				return ResponseEntity.body(cinemaService.save(cinema));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Cinema> optionalCinema = cinemaService.findById(id);
			if (optionalCinema.isPresent()) {
				Cinema cinema = optionalCinema.orElse(null);
				return ResponseEntity.body(cinema);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		if (name == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Cinema> listCinema = cinemaService.findByName(name);
			if (listCinema.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listCinema);
			}
		}
	}
}
