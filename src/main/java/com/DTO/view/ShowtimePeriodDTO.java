package com.DTO.view;

import java.util.List;

import com.Entity.Movie;

public class ShowtimePeriodDTO {
	private Integer showtimeId;
	private Integer periodId;
	private String startTime;
	private Integer statusDay;
	private Float price;
	private List<Movie> movies;

	public ShowtimePeriodDTO() {
		super();
	}

	public ShowtimePeriodDTO(Integer showtimeId, Integer periodId, String startTime, Integer statusDay, Float price,
			List<Movie> movies) {
		super();
		this.showtimeId = showtimeId;
		this.periodId = periodId;
		this.startTime = startTime;
		this.statusDay = statusDay;
		this.price = price;
		this.movies = movies;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getStatusDay() {
		return statusDay;
	}

	public void setStatusDay(Integer statusDay) {
		this.statusDay = statusDay;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
