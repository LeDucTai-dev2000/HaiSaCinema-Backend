package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query(value="FROM Role r WHERE r.roleId = :id ")
	Role findRoleById(Integer id);
}
