package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.CinemaDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Cinema;
import com.Entity.Role;
import com.Services.CinemaService;
import com.Services.RoleService;

@RestController
@RequestMapping(value = "role")

public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> index() {
		return ResponseEntity.body(roleService.getAll());
	}
}
