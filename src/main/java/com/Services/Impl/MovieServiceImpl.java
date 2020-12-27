package com.Services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Movie;
import com.Entity.Showtimes;
import com.Repository.GenreMovieRepository;
import com.Repository.MovieGenreDetailRepository;
import com.Repository.MovieRepository;
import com.Services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository repository;
	@Autowired
	GenreMovieRepository genreRepository;
	@Autowired
	MovieGenreDetailRepository movieGenreDetailRepository;

	public void deleteAll() {
		repository.deleteAll();
	}

	public Movie add(Movie movie) {
		return repository.save(movie);
	}

	public List<Movie> addAll(List<Movie> list) {
		List<Movie> res = new ArrayList<>();
		for (Movie movie : list) {
			res.add(add(movie));
		}
		return res;
	}

	public Optional<Movie> findById(Integer id) {
		return repository.findById(id);
	}

	public List<Movie> findByName(String name, Integer status) {
		return repository.findByMovieName(name, status);
	}

	public Movie save(Movie movie) {
		return repository.saveAndFlush(movie);
	}

	public List<Movie> findMovieByStatus(Integer status) {
		return repository.findMovieByStatus(status);
	}

	@Override
	public List<Movie> getAll() {
		return repository.findAll();
	}

	public void updateMovieStatus() {
		Date now = new Date();
		long previousSevenDateLong = now.getTime() - 604800000;
		Date previousSevenDate = new Date(previousSevenDateLong);
		long nextSevenDateLong = now.getTime() + 604800000;
		Date nextSevenDate = new Date(nextSevenDateLong);
		long nextThreeWeekLong = nextSevenDate.getTime() + 1814400000;
		Date nextThreeWeek = new Date(nextThreeWeekLong);
		
		
		List<Integer> listMovieId = repository.findMovieByNextDay(previousSevenDate, now);
		listMovieId.forEach(movieId -> {
			Movie movie = repository.findById(movieId).orElse(null);
			movie.setStatus(3);
			repository.saveAndFlush(movie);
		});
		
		
		listMovieId = repository.findMovieByNextDay(nextSevenDate, nextThreeWeek);
		listMovieId.forEach(movieId -> {
			Movie movie = repository.findById(movieId).orElse(null);
			movie.setStatus(2);
			repository.saveAndFlush(movie);
		});
		
		
		listMovieId = repository.findMovieByNextDay(now, nextSevenDate);
		listMovieId.forEach(movieId -> {
			Movie movie = repository.findById(movieId).orElse(null);
			movie.setStatus(1);
			repository.saveAndFlush(movie);
		});
	}

	@Override
	public List<Movie> findByMovieName(String name) {
		return repository.findByMovieName(name);
	}

}
