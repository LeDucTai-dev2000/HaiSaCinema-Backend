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
import com.DTO.GenreMovieDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.Entity.MovieGenreDetail;
import com.Services.GenreMovieService;
import com.Services.MovieGenreDetailService;

@RestController
@RequestMapping(value = "genre")

public class GenreController {

	@Autowired
	private GenreMovieService genreService;
	@Autowired
	private MovieGenreDetailService movieGenreDetailService;

	@GetMapping
	public ResponseEntity<List<GenreMovie>> index() {
		return ResponseEntity.body(genreService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addGenreMovie(@RequestBody GenreMovieDTO genreDTO) {
		if (genreDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			genreDTO.setGenreId(null);
			GenreMovie genre = genreDTO.convertToGenreEntity();
			return ResponseEntity.body(genreService.save(genre));
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateGenreMovie(@RequestBody GenreMovieDTO genreDTO) {
		if (genreDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {

			Optional<GenreMovie> checkGenre = genreService.findById(genreDTO.getGenreId());
			if (checkGenre.isPresent()) {
				GenreMovie genre = genreDTO.convertToGenreEntity();
				return ResponseEntity.body(genreService.save(genre));
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
			Optional<GenreMovie> optionalGenre = genreService.findById(id);
			if (optionalGenre.isPresent()) {
				GenreMovie genreMovie = optionalGenre.orElse(null);
				return ResponseEntity.body(genreMovie);
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
			List<GenreMovie> listGenre = genreService.findByName(name);
			if (listGenre.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listGenre);
			}
		}
	}

	@GetMapping("/findbymovie")
	public ResponseEntity<Object> findByMovieId(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<MovieGenreDetail> listGenreDetail = movieGenreDetailService.findAllByMovieId(id);
			if (listGenreDetail.isEmpty()) {
				return ResponseEntity.body(Constant.NOT_FOUND);
			} else {
				return ResponseEntity.body(listGenreDetail);
			}
			
		}
	}
}
