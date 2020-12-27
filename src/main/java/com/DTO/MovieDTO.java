package com.DTO;

import java.util.List;

import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieDTO {

	private Integer movieId;
	private String movieName;
	private Integer duration;
	private String description;
	private String thumbnail;
	private String trailer;
	private String actors;
	private String director;
	private Integer ageLimit;
	private Integer status;
	private List<GenreMovieDTO> listGenre;

	public MovieDTO(Integer movieId, String movieName, Integer duration, String description, String thumbnail,
			String trailer, String actors, String director, Integer ageLimit) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.duration = duration;
		this.description = description;
		this.thumbnail = thumbnail;
		this.trailer = trailer;
		this.actors = actors;
		this.director = director;
		this.ageLimit = ageLimit;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(movieName) || isNull(duration) || isNull(description) || isNull(thumbnail)
				|| isNull(actors) || isNull(director) || isNull(ageLimit);
		return includeId ? res || isNull(movieId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}
	public Movie convertToMovie(MovieDTO movieDTO) {
		Movie movie = new Movie();
		movie.setMovieId(movieDTO.getMovieId());
		movie.setMovieName(movieDTO.getMovieName());
		movie.setDuration(movieDTO.getDuration());
		movie.setDescription(movieDTO.getDescription());
		movie.setActors(movieDTO.getActors());
		movie.setDirector(movieDTO.getDirector());
		movie.setAgeLimit(movieDTO.getAgeLimit());
		movie.setThumbnail(movieDTO.getThumbnail());
		movie.setTrailer(movieDTO.getTrailer());
		movie.setStatus(movieDTO.getStatus());
		return movie;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public MovieDTO(List<GenreMovieDTO> listGenre) {
		super();
		this.listGenre = listGenre;
	}

	public List<GenreMovieDTO> getListGenre() {
		return listGenre;
	}

	public void setListGenre(List<GenreMovieDTO> listGenre) {
		this.listGenre = listGenre;
	}

	public MovieDTO() {
		super();
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", duration=" + duration + ", description="
				+ description + ", thumbnail=" + thumbnail + ", actors=" + actors + ", director=" + director
				+ ", ageLimit=" + ageLimit + ", status=" + status + "]";
	}
}
