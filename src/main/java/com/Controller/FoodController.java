package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Constant.*;
import com.DTO.FoodDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Food;
import com.Entity.Movie;
import com.Services.FoodService;

@RestController
@RequestMapping(value = "food")

public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping
	public ResponseEntity<List<Food>> getAllFood() {
		return ResponseEntity.body(foodService.getAllFood());
	}

	@GetMapping(value = "/{status}")
	public ResponseEntity<List<Food>> getFoodByStatus(@PathVariable("status") Integer status) {
		// tìm danh sách food theo status : 1: đang kinh doanh 2: ngừng kinh doanh
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return ResponseEntity.body(foodService.getAllByStatus(st));
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			foodDTO.setFoodId(null);
			foodDTO.setStatus(1);
			Food food = foodDTO.convertToFood();
			foodService.add(food);
			return ResponseEntity.body(foodDTO);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateFood(@RequestBody FoodDTO foodDTO) {
		if (foodDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Food> checkFood = foodService.findById(foodDTO.getFoodId());
			if (checkFood.isPresent()) {
				Food food = foodDTO.convertToFood();
				return ResponseEntity.body(foodService.save(food));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteFood(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Food> checkFood = foodService.findById(id);
			if (checkFood.isPresent()) {
				Food food = checkFood.orElse(null);
				// status =1 : đang bán, status = 2 : ngừng bán
				food.setStatus(2);
				return ResponseEntity.body(foodService.save(food));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Food> optionalFood = foodService.findById(id);
			if (optionalFood.isPresent()) {
				Food food = optionalFood.orElse(null);
				return ResponseEntity.body(food);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name, Integer status) {
		if (name == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			if (status == null) {
				return ResponseEntity.body(Constant.BAD_REQUEST);
			} else {
				List<Food> listFood = foodService.findByName(name, status);
				if (listFood.isEmpty()) {
					return ResponseEntity.body(Constant.NOT_FOUND);
				} else {
					return ResponseEntity.body(listFood);
				}
			}
		}
	}

}
