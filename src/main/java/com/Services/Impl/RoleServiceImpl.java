package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Role;
import com.Repository.RoleRepository;
import com.Services.RoleService;
import com.Services.UserService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository repository;

	@Override
	public Role findById(Integer id) {
		return repository.findRoleById(id);
	}

	@Override
	public List<Role> getAll() {
		return repository.findAll();
	}

	
}
