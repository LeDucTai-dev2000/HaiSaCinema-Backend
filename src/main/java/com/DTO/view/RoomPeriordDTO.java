package com.DTO.view;

import java.util.List;

import com.Entity.Room;

public class RoomPeriordDTO {

	private Room room;
	private List<ShowtimePeriodDTO> periods;

	public RoomPeriordDTO() {
		super();
	}

	public RoomPeriordDTO(Room room, List<ShowtimePeriodDTO> periods) {
		super();
		this.room = room;
		this.periods = periods;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<ShowtimePeriodDTO> getPeriods() {
		return periods;
	}

	public void setPeriods(List<ShowtimePeriodDTO> periods) {
		this.periods = periods;
	}

}
