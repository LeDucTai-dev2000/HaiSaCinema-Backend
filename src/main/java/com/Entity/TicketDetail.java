package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticketdetail")
public class TicketDetail {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ticketdetailid", unique = true, nullable = false)
	private Integer ticketDetailId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "seatid")
	private Seat seat;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ticketid")
	private Ticket ticket;

	public TicketDetail() {

	}

	public Integer getTicketDetailId() {
		return ticketDetailId;
	}

	public void setTicketDetailId(Integer ticketDetailId) {
		this.ticketDetailId = ticketDetailId;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
