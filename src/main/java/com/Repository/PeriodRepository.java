package com.Repository;

import com.Entity.Period;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {

	@Query("FROM Period p WHERE p.statusDay = :status")
	List<Period> findPeriodByStatus(Integer status);

	@Query(value = "SELECT p FROM Period p WHERE p.startTime LIKE %:name% ")
	List<Period> findByName(String name);

}
