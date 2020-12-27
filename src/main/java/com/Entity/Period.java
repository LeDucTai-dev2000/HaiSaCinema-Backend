package com.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "period")
public class Period {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "periodid", unique = true, nullable = false)
	private Integer periodId;

	@Column(name = "starttime")
	private String startTime;

	@Column(name = "statusday")
	private Integer statusDay;

	@Column(name = "price")
	private Float price;

	@JsonIgnore
	@OneToMany(mappedBy = "period")
	private List<Showtimes> showtimes;

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getStatusDay() {
		return statusDay;
	}

	public void setStatusDay(Integer statusDay) {
		this.statusDay = statusDay;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Showtimes> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtimes> showtimes) {
		this.showtimes = showtimes;
	}

}
