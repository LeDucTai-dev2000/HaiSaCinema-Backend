package com.Services;

import org.springframework.stereotype.Service;

import com.Entity.Role;
import com.Entity.UserRole;

@Service
public interface UserRoleService {
	/**
	 * Saves a entity UserRole
	 * 
	 * @return entity UserRole
	 */
	UserRole add(UserRole userRole);

	/**
	 * Delete all entity UserRole where exists userId entered
	 * 
	 * @return void
	 */
	void deleteByUserId(Integer id);

}
