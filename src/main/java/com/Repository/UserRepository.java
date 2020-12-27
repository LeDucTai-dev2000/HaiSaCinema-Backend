package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	@Query(value = "SELECT u FROM User u  WHERE u.email = :email ")
	User getUserByEmail(String email);

	@Query(value = "SELECT u FROM User u  WHERE u.email = :email ")
	Optional<User> checkUserByEmail(String email);
	
	@Query(value = "SELECT u.email FROM User u")
	List<String> findAllEmail();
}
