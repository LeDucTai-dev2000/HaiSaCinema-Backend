package com.Services.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.MovieGenreDetail;
import com.Repository.MovieGenreDetailRepository;
import com.Services.MovieGenreDetailService;

@Service
public class MovieGenreDetailServiceImpl implements MovieGenreDetailService {
	@Autowired
	MovieGenreDetailRepository repository;
	

	@Override
	public MovieGenreDetail add(MovieGenreDetail movieGenreDetail) {
		return repository.save(movieGenreDetail);
	}

	@Override
	public MovieGenreDetail save(MovieGenreDetail movieGenreDetail) {
		return repository.saveAndFlush(movieGenreDetail);
	}

	@Override
	public Optional<MovieGenreDetail> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void deleteByMovieId(Integer movieId) {
		repository.deleteByMovieId(movieId);
	}

	@Override
	public List<MovieGenreDetail> findAllByMovieId(Integer movieId) {
		return repository.findAllByMovieMovieId(movieId);
	}

	@Override
	public List<MovieGenreDetail> findAllByGenre(Integer genreId) {
		return repository.findAllByGenre(genreId);
	}

}
