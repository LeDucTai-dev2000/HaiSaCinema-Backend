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
@Table(name = "seat")
public class Seat {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "seatid", unique = true, nullable = false)
	private Integer seatId;

	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;

	@Column(name = "seatname")
	private String seatName;

	@JsonIgnore
	@OneToMany(mappedBy = "seat")
	private List<SeatStatus> seatStatus;

	@JsonIgnore
	@OneToMany(mappedBy = "seat")
	private List<TicketDetail> ticketDetail;

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public List<SeatStatus> getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(List<SeatStatus> seatStatus) {
		this.seatStatus = seatStatus;
	}

	public List<TicketDetail> getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(List<TicketDetail> ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

	@Override
	public String toString() {
		return " " + getSeatId() + " " + getSeatName() + " ";
	}

}
