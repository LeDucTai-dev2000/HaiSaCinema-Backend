package com.DTO.view;

import java.util.List;

import com.Entity.Cinema;

public class CinemaShowtimeViewDTO {

	private Cinema cinema;
	private List<DatePeriodDTO> datePeriodDTO;

	public CinemaShowtimeViewDTO() {
		super();
	}

	public CinemaShowtimeViewDTO(Cinema cinema, List<DatePeriodDTO> datePeriodDTO) {
		super();
		this.cinema = cinema;
		this.datePeriodDTO = datePeriodDTO;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<DatePeriodDTO> getDatePeriodDTO() {
		return datePeriodDTO;
	}

	public void setDatePeriodDTO(List<DatePeriodDTO> datePeriodDTO) {
		this.datePeriodDTO = datePeriodDTO;
	}

}
