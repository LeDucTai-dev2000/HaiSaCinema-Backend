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
@Table(name = "food")
public class Food {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "foodid", unique = true, nullable = false)
	private Integer foodId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Float price;

	@Column(name = "status")
	private Integer status;

	@JsonIgnore
	@OneToMany(mappedBy = "food")
	private List<FoodBillDetail> foodBillDetail;

	public Food() {
		super();
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<FoodBillDetail> getFoodBillDetail() {
		return foodBillDetail;
	}

	public void setFoodBillDetail(List<FoodBillDetail> foodBillDetail) {
		this.foodBillDetail = foodBillDetail;
	}

}
