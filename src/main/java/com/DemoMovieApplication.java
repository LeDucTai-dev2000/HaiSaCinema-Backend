package com;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Entity.Role;
import com.Entity.User;
import com.Repository.RoleRepository;
import com.Services.UserRoleService;
import com.Services.UserService;

@SpringBootApplication
@EnableScheduling
public class DemoMovieApplication implements CommandLineRunner{
	@Autowired
	RoleRepository roleService;
	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	PasswordEncoder passwordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(DemoMovieApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMovieApplication.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Role> listRole = roleService.findAll();
		if(listRole == null || listRole.size() ==0) {
			logger.info("Đefault Role is NUll, Try to init Default list Role");
			Role r = new Role();
			r.setName("ROLE_ADMIN");
			roleService.save(r);
			Role r2 = new Role();
			r2.setName("ROLE_USER");
			roleService.save(r2);
			logger.info("Init list Role Done");
		} else {
			logger.info("Exist Defaul list Role");
		}
		
		User listUser = userService.findByEmail("admin@gmail.com").orElse(null);
		if(listUser == null) {
			logger.info("Đefault User is NUll, Try to init Default User");
			User u = new User();
			u.setEmail("admin@gmail.com");
			u.setPassword(passwordEncoder.encode("admin"));
			userService.add(u);
			logger.info("Init User Done");
		} else {
			logger.info("Exist Defaul User");
		}
			
	}
	
	
}
