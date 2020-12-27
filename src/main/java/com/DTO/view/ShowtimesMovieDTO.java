package com.DTO.view;

import java.util.List;

import com.Entity.Period;

public class ShowtimesMovieDTO {
	private Integer cinemaId;
	private String cinemaName;
	private String address;
	private List<DatePeriodDTO> periods;

	public ShowtimesMovieDTO() {
		super();
	}

	public ShowtimesMovieDTO(Integer cinemaId, String cinemaName, String address, List<DatePeriodDTO> periods) {
		super();
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.address = address;
		this.periods = periods;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<DatePeriodDTO> getPeriods() {
		return periods;
	}

	public void setPeriods(List<DatePeriodDTO> periods) {
		this.periods = periods;
	}

}
