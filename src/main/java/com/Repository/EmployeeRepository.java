package com.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.employeeId = :id AND e.status = 1")
	Optional<Employee> findEmployeeById(Integer id);

	@Query("FROM Employee e WHERE e.status = :status")
	List<Employee> findEmployeeByStatus(Integer status);

	@Query(value = "SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.status = :status")
	List<Employee> findByName(String name, Integer status);

	@Query(value = "SELECT e FROM Employee e WHERE e.user.email = :email ")
	Employee getEmployeeByEmail(String email);
}
