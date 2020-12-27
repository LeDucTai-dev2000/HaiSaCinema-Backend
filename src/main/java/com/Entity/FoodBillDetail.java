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
@Table(name = "foodbilldetail")
public class FoodBillDetail {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "foodbilldetail", unique = true, nullable = false)
	private Integer foodBillDetail;

	@ManyToOne
	@JoinColumn(name = "foodid")
	private Food food;

	@ManyToOne
	@JoinColumn(name = "ticketid")
	private Ticket ticket;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "total")
	private Double total;

	public FoodBillDetail() {
	}

	public Integer getFoodBillDetail() {
		return foodBillDetail;
	}

	public void setFoodBillDetail(Integer foodBillDetail) {
		this.foodBillDetail = foodBillDetail;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
