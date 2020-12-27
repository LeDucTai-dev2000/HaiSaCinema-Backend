package com.DTO.view;

import java.util.Date;
import java.util.List;

public class DatePeriodDTO {
	private Date date;
	private List<ShowtimePeriodDTO> periods;
	private List<RoomPeriordDTO> rooms;

	public DatePeriodDTO() {
		super();
	}

	public DatePeriodDTO(Date date, List<ShowtimePeriodDTO> periods, List<RoomPeriordDTO> rooms) {
		super();
		this.date = date;
		this.periods = periods;
		this.rooms = rooms;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ShowtimePeriodDTO> getPeriods() {
		return periods;
	}

	public void setPeriods(List<ShowtimePeriodDTO> periods) {
		this.periods = periods;
	}

	public List<RoomPeriordDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomPeriordDTO> rooms) {
		this.rooms = rooms;
	}

}
