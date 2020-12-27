package com.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.EmployeeDTO;
import com.Entity.Employee;
import com.Entity.Movie;
import com.Entity.Role;
import com.Entity.User;
import com.Entity.UserRole;
import com.Services.EmployeeService;
import com.Services.UserRoleService;
import com.Services.UserService;
import com.Constant.*;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "employee")

public class EmployeeController {

	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.body(employeeService.getAll());
	}

	@GetMapping("/{status}")
	public ResponseEntity<Object> getEmployeePresent(@PathVariable("status") Integer status) {
		// tìm danh sách employee theo status : 1 : đang hoạt động 2: ngưng hoạt động
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		List<Employee> listEmployee = employeeService.getAllByStatus(st);
		if (listEmployee.isEmpty()) {
			return ResponseEntity.body(Constant.NOT_FOUND);
		} else {
			return ResponseEntity.body(listEmployee);
		}
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Optional<User> checkUser = userService.findByEmail(employeeDTO.getEmail());
		if (employeeDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		}
		if (checkUser.isPresent()) {
			return ResponseEntity.body(Constant.Exception.MESSAGE);
		} else {
			User user = new User();
			user.setEmail(employeeDTO.getEmail());
			String password = passwordEncoder.encode(employeeDTO.getPassword());
			user.setPassword(password);
			user = userService.add(user);
			List<Role> listRole = employeeDTO.getListRole();
			for (Role role : listRole) {
				UserRole userRole = new UserRole();
				userRole.setUser(user);
				userRole.setRole(role);
				userRoleService.add(userRole);
			}
			employeeDTO.setEmployeeId(null);
			Employee employee = employeeService.convertToEmployee(employeeDTO);
			employee.setUser(user);
			return ResponseEntity.body(employeeService.add(employee));
		}
	}

	@GetMapping("/getrole")
	public ResponseEntity<Object> getRoleByEmployee(Integer employeeId) {
		Optional<Employee> checkEmployee = employeeService.findById(employeeId);
		List<UserRole> listUserRole = checkEmployee.orElse(null).getUser().getUserRole();
		List<Role> listRole = new ArrayList<Role>();
		for (UserRole userRole : listUserRole) {
			listRole.add(userRole.getRole());
		}
		return ResponseEntity.body(listRole);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Employee> checkEmployee = employeeService.findById(employeeDTO.getEmployeeId());
			if (checkEmployee.isPresent()) {
				User user = checkEmployee.orElse(null).getUser();
				userRoleService.deleteByUserId(user.getUserId());
				List<Role> listRole = employeeDTO.getListRole();
				for (Role role : listRole) {
					UserRole userRole = new UserRole();
					userRole.setUser(user);
					userRole.setRole(role);
					userRoleService.add(userRole);
				}
				Employee employee = employeeService.convertToEmployee(employeeDTO);
				employee.setUser(user);
				employee = employeeService.save(employee);
				return ResponseEntity.body(employee);
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}

	}

	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteEmployee(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Employee> checkEmployee = employeeService.findById(id);
			if (checkEmployee.isPresent()) {
				Employee employee = checkEmployee.orElse(null);
				// status = 1 : đang hoạt động, status = 2 : ngưng hoạt động
				employee.setStatus(2);
				
				return ResponseEntity.body(employeeService.save(employee));
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
			Optional<Employee> optionalEmployee = employeeService.findById(id);
			if (optionalEmployee.isPresent()) {
				Employee employee = optionalEmployee.orElse(null);
				return ResponseEntity.body(employee);
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
				List<Employee> listEmployee = employeeService.findByName(name, status);
				if (listEmployee.isEmpty()) {
					return ResponseEntity.body(Constant.NOT_FOUND);
				} else {
					return ResponseEntity.body(listEmployee);
				}
			}
		}
	}
	@GetMapping("/getemployee")
	public ResponseEntity<Employee> getEmployeeByEmail(String email) {
		Employee employee = employeeService.getEmployeeByEmail(email);
		return ResponseEntity.body(employee);
	}

}
