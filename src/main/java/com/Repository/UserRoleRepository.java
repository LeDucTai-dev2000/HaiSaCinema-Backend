package com.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM UserRole u WHERE u.user.userId = :id ")
	void deleteByUserId(Integer id);
}
