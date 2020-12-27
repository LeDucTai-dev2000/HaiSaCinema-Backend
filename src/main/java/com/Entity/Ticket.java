package com.Entity;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
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
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ticketid", unique = true, nullable = false)
	private Integer ticketId;

	@ManyToOne
	@JoinColumn(name = "memberid")
	private Member member;

	@Column(name = "ticketquantity")
	private Integer ticketQuantity;

	@Column(name = "ticketpriceamount")
	private Double ticketPriceAmount;

	@Column(name = "code")
	private String code;

	@Column(name = "total")
	private Double total;
	
	@Column(name="date")
	private Date date;

	@OneToMany(mappedBy = "ticket")
	@JsonIgnore
	private List<TicketDetail> ticketDetail;

	@OneToMany(mappedBy = "ticket")
	@JsonIgnore
	private List<FoodBillDetail> foodBillDetail;

	@ManyToOne
	@JoinColumn(name = "showtimeid")
	private Showtimes showtimes;

	public Ticket() {

	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Integer getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(Integer ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public Double getTicketPriceAmount() {
		return ticketPriceAmount;
	}

	public void setTicketPriceAmount(Double ticketPriceAmount) {
		this.ticketPriceAmount = ticketPriceAmount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<TicketDetail> getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(List<TicketDetail> ticketDetail) {
		this.ticketDetail = ticketDetail;
	}

	public List<FoodBillDetail> getFoodBillDetail() {
		return foodBillDetail;
	}

	public void setFoodBillDetail(List<FoodBillDetail> foodBillDetail) {
		this.foodBillDetail = foodBillDetail;
	}

	public Showtimes getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Showtimes showtimes) {
		this.showtimes = showtimes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
