package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roomId", unique = true, nullable = false)
	private Integer roomId;

	@ManyToOne
	@JoinColumn(name = "cinemaId")
	private Cinema cinema;

	@Column(name = "roomname")
	private Integer roomName;

	@Column(name = "seatamount")
	private Integer seatAmount;

	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Showtimes> showtimes;

	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Seat> seat;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Integer getRoomName() {
		return roomName;
	}

	public void setRoomName(Integer roomName) {
		this.roomName = roomName;
	}

	public Integer getSeatAmount() {
		return seatAmount;
	}

	public void setSeatAmount(Integer seatAmount) {
		this.seatAmount = seatAmount;
	}

	public List<Showtimes> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtimes> showtimes) {
		this.showtimes = showtimes;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

//	public Room(Integer roomId) {
//		super();
//		this.roomId = roomId;
//	}

}
