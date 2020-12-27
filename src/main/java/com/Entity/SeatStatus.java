package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seatstatus")
public class SeatStatus {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "seatstatusid", unique = true, nullable = false)
	private Integer seatStatusId;

	@ManyToOne
	@JoinColumn(name = "seatid")
	private Seat seat;

	@ManyToOne
	@JoinColumn(name = "showtimeid")
	private Showtimes showtimes;

	@Column(name = "status")
	private Boolean status;

	public Integer getSeatStatusId() {
		return seatStatusId;
	}

	public void setSeatStatusId(Integer seatStatusId) {
		this.seatStatusId = seatStatusId;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Showtimes getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Showtimes showtimes) {
		this.showtimes = showtimes;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
