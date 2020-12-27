package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	@Query("FROM Food f WHERE f.status = :status")
	List<Food> findFoodByStatus(Integer status);
	
	@Query("FROM Food f WHERE f.foodId = :id AND f.status = 1")
	Optional<Food> findFoodById(Integer id);

	@Query(value = "SELECT f FROM Food f WHERE f.name LIKE %:name% AND f.status = :status")
	List<Food> findFoodByName(String name, Integer status);
	
}
