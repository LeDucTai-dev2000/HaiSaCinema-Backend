package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Role;
import com.Entity.UserRole;
import com.Repository.UserRoleRepository;
import com.Services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserRole add(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}

	@Override
	public void deleteByUserId(Integer id) {
		userRoleRepository.deleteByUserId(id);	
	}
	
	
	
}
