package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Entity.Role;

@Service
public interface RoleService {
	/**
	 * Search an entity Role by its id
	 * 
	 * @return the entity with the RoleId entered
	 */
	Role findById(Integer id);

	/**
	 * Find all entity Role
	 * 
	 * @return List<Role>
	 */
	List<Role> getAll();
}
