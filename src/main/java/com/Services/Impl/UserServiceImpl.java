package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.User;
import com.Repository.UserRepository;
import com.Services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with email : " + email));
		return UserPrinciple.build(user);
	}

	@Override
	public User add(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return repository.getUserByEmail(email);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Optional<User> checkUserByEmail(String email) {
		return repository.checkUserByEmail(email);
	}

	@Override
	public List<String> getAllEmail() {
		return repository.findAllEmail();
	}


}
