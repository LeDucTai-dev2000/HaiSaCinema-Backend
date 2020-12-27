package com.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cinema")
public class Cinema {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cinemaid", unique = true, nullable = false)
	private Integer cinemaId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	private List<Room> room;

	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	private List<Employee> employee;

	public Cinema() {
		super();
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaId")
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
