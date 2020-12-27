package com.DTO;

import com.Entity.Food;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodDTO {

	private Integer foodId;
	private String name;
	private Float price;
	private Integer status;

	public FoodDTO() {
		super();
	}

	public FoodDTO(Integer foodId, String name, Float price, Integer status) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.price = price;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(name) || isNull(price);
		return includeId ? res || isNull(foodId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	private boolean isNull(Float input) {
		return input == null;
	}

	public Food convertToFood() {
		ObjectMapper mapper = new ObjectMapper();
		Food food = mapper.convertValue(this, Food.class);
		if (isNull(status)) {
			food.setStatus(1);
		}
		return food;
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

	@Override
	public String toString() {
		return "FoodDTO [foodId=" + foodId + ", name=" + name + ", price=" + price + ", status=" + status + "]";
	}

}
