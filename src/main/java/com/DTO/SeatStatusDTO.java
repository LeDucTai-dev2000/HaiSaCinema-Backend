package com.DTO;

import com.Entity.Cinema;
import com.Entity.Movie;
import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatStatusDTO {
	private Integer seatStatusId;
	private Integer showtimeId;
	private Integer seatId;
	private int status;
	private Showtimes showtimes;
	private Seat seat;

	public SeatStatusDTO() {

	}
	public SeatStatusDTO(Integer seatStatusId, Integer showtimeId, Integer seatId, int status) {
		super();
		this.seatStatusId = seatStatusId;
		this.showtimeId = showtimeId;
		this.seatId = seatId;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(showtimeId) || isNull(seatId);
		return includeId ? res || isNull(seatStatusId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Integer getSeatStatusId() {
		return seatStatusId;
	}

	public void setSeatStatusId(Integer seatStatusId) {
		this.seatStatusId = seatStatusId;
	}

	public Showtimes getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Showtimes showtimes) {
		this.showtimes = showtimes;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimesId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	@Override
	public String toString() {
		return "SeatStatusDTO [seatStatusId=" + seatStatusId + ", showtimes=" + showtimes + ", seat=" + seat
				+ ", status=" + status + "]";
	}

}
