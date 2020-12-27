package com.Entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "showtimes")
public class Showtimes {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "showtimeid", unique = true, nullable = false)
	private Integer showtimeId;

	@ManyToOne
	@JoinColumn(name = "employeeid")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "movieid")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name = "periodid")
	private Period period;

	@ManyToOne
	@JoinColumn(name = "roomid")
	private Room room;

	@Column(name = "date")
	private Date date;

	@Column(name = "status")
	private Integer status;

	@JsonIgnore
	@OneToMany(mappedBy = "showtimes")
	private List<SeatStatus> seatStatus;

	public Showtimes() {

	}

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public List<SeatStatus> getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(List<SeatStatus> seatStatus) {
		this.seatStatus = seatStatus;
	}

}
