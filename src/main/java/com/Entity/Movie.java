package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "movieid", unique = true, nullable = false)
	private Integer movieId;

	@Column(name = "moviename")
	private String movieName;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "description")
	private String description;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "trailer")
	private String trailer;

	@Column(name = "actors")
	private String actors;

	@Column(name = "director")
	private String director;

	@Column(name = "agelimit")
	private Integer ageLimit;

	@Column(name = "status")
	private Integer status;

	@OneToMany(mappedBy = "movie")
	@JsonIgnore
	private List<MovieGenreDetail> movieGenreDetail;

	@OneToMany(mappedBy = "movie")
	@JsonIgnore
	private List<Showtimes> showtimes;

	public Movie() {
		super();
	}

	public Movie(Integer movieId, String movieName, Integer duration, String description, String thumbnail,
			String trailer, String actors, String director, Integer ageLimit, Integer status,
			List<MovieGenreDetail> movieGenreDetail, List<Showtimes> showtimes) {
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
		this.status = status;
		this.movieGenreDetail = movieGenreDetail;
		this.showtimes = showtimes;
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

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
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

	public List<MovieGenreDetail> getMovieGenreDetail() {
		return movieGenreDetail;
	}

	public void setMovieGenreDetail(List<MovieGenreDetail> movieGenreDetail) {
		this.movieGenreDetail = movieGenreDetail;
	}

	public List<Showtimes> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtimes> showtimes) {
		this.showtimes = showtimes;
	}

}
