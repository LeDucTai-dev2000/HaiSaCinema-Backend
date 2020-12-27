package com.DTO;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Showtimes;
import com.Services.EmployeeService;
import com.Services.MovieService;
import com.Services.PeriodService;
import com.Services.RoomService;

@Service
public class ShowtimesDTO {
	
	
	private Integer showtimeId;
	private Integer movieId;
	private Integer roomId;
	private Date date;
	private Integer periodId;
	private Integer employeeId;
	private Integer status;

	public ShowtimesDTO(){

	}

	public ShowtimesDTO(Integer showtimeId, Integer movieId, Integer roomId, Date date, Integer periodId,
			Integer employeeId, Integer status) {
		super();
		this.showtimeId = showtimeId;
		this.movieId = movieId;
		this.roomId = roomId;
		this.date = date;
		this.periodId = periodId;
		this.employeeId = employeeId;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(movieId) || isNull(roomId) || isNull(periodId) || isNull(employeeId);
		return includeId ? res || isNull(showtimeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "ShowtimesDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", roomId=" + roomId + ", date="
				+ date + ", periodId=" + periodId + ", employeeId=" + employeeId +  ", status=" + status + "]";
	}

}
