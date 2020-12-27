package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.GenreMovie;
import com.Repository.GenreMovieRepository;
import com.Services.GenreMovieService;

@Service
public class GenreMovieImpl implements GenreMovieService {
	@Autowired
	GenreMovieRepository repository;

	@Override
	public List<GenreMovie> getAll() {
		return repository.findAll();
	}

	@Override
	public GenreMovie save(GenreMovie genre) {
		return repository.save(genre);
	}

	@Override
	public Optional<GenreMovie> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<GenreMovie> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public GenreMovie add(GenreMovie genre) {
		return repository.save(genre);
	}

}
