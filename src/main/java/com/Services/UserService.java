package com.Services;

import com.Entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	/**
	 * Saves a entity User
	 * 
	 * @return entity User
	 */
	User add(User user);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity User
	 */
	User update(User user);

	/**
	 * Get entity User by email entered
	 * 
	 * @return entity User
	 */
	User getUserByEmail(String email);

	/**
	 * The function that check user's email exists or not
	 * 
	 * @return <Optional> User
	 */
	Optional<User> checkUserByEmail(String email);

	/**
	 * Search an entity User by its email
	 * 
	 * @return the entity with the email entered or Optional#empty() if none found.
	 */
	Optional<User> findByEmail(String email);

	/**
	 * Find all email of entity User
	 * 
	 * @return List<String>
	 */
	List<String> getAllEmail();
}
