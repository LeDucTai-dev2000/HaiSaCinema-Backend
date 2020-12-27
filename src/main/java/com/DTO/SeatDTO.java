package com.DTO;


import com.Entity.Room;

import com.Entity.Seat;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeatDTO {
	private Integer seatId;
	private String seatName;
	private Integer roomId;

	public SeatDTO() {
		super();
	}

	public SeatDTO(Integer seatId, String seatName, Integer roomId) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.roomId = roomId;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(seatName) || isNull(roomId);
		return includeId ? res || isNull(seatId) : res;
	}

	public Seat convertToDTO() {
		Room room = new Room();
		Seat seat = new Seat();
		room.setRoomId(this.getRoomId());
		seat.setRoom(room);
		seat.setSeatId(this.getSeatId());
		seat.setSeatName(this.getSeatName());
		return seat;
	}


    public Integer getSeatId() {
		return seatId;
	}
    
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "SeatDTO [seatId=" + seatId + ", seatName=" + seatName + "]";
	}


}
