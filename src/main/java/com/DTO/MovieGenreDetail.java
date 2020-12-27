package com.DTO;

import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieGenreDetail {

	private Integer movieGenreDetailId;
	private Integer genreMovieId;
	private Integer movieId;
	private GenreMovie genreMovie;
	private Movie movie;

	public MovieGenreDetail() {
		super();
	}

	public MovieGenreDetail(Integer movieGenreDetailId, Integer genreMovieId, Integer movieId) {
		super();
		this.movieGenreDetailId = movieGenreDetailId;
		this.genreMovieId = genreMovieId;
		this.movieId = movieId;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(genreMovieId) || isNull(movieId);
		return includeId ? res || isNull(movieGenreDetailId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public MovieGenreDetail convertToGenreEntity() {
		Movie movie = new Movie();
		movie.setMovieId(this.getMovieId());
		this.setMovie(movie);
		GenreMovie genreMovie = new GenreMovie();
		genreMovie.setGenreId(this.getGenreMovieId());
		this.setGenreMovie(genreMovie);
		ObjectMapper mapper = new ObjectMapper();
		MovieGenreDetail movieGenreDetail = mapper.convertValue(this, MovieGenreDetail.class);
		return movieGenreDetail;

	}

	public Integer getMovieGenreDetailId() {
		return movieGenreDetailId;
	}

	public void setMovieGenreDetailId(Integer movieGenreDetailId) {
		this.movieGenreDetailId = movieGenreDetailId;
	}

	public GenreMovie getGenreMovie() {
		return genreMovie;
	}

	public void setGenreMovie(GenreMovie genreMovie) {
		this.genreMovie = genreMovie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getGenreMovieId() {
		return genreMovieId;
	}

	public void setGenreMovieId(Integer genreMovieId) {
		this.genreMovieId = genreMovieId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "MovieGenreDetail [movieGenreDetailId=" + movieGenreDetailId + ", genreMovie=" + genreMovie + ", movie="
				+ movie + "]";
	}

}
