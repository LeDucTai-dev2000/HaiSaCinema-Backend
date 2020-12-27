package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DTO.EmployeeDTO;
import com.Entity.Cinema;
import com.Entity.Employee;
import com.Repository.EmployeeRepository;
import com.Services.EmployeeService;
import com.Services.UserService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repository;

	@Autowired
	UserService userService;

	public List<Employee> getAllByStatus(Integer st) {
		return repository.findEmployeeByStatus(st);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Employee add(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> addAll(List<Employee> list) {
		List<Employee> res = new ArrayList<>();
		for (Employee employee : list) {
			res.add(add(employee));
		}
		return res;
	}

	public Optional<Employee> findById(Integer id) {
		return repository.findEmployeeById(id);
	}

	public List<Employee> findByName(String name, Integer status) {
		return repository.findByName(name, status);
	}

	public Employee save(Employee employee) {
		return repository.saveAndFlush(employee);
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee convertToEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		Cinema cinema = new Cinema();
		cinema.setCinemaId(employeeDTO.getCinemaId());
		employee.setCinema(cinema);
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setName(employeeDTO.getName());
		employee.setBirthday(employeeDTO.getBirthday());
		employee.setPhone(employeeDTO.getPhone());
		employee.setIdCard(employeeDTO.getIdCard());
		employee.setAddress(employeeDTO.getAddress());
		employee.setStatus(1);
		return employee;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return repository.getEmployeeByEmail(email);
	}
}
