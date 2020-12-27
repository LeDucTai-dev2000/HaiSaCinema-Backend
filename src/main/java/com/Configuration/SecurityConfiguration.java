package com.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Services.Impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable().authorizeRequests()
				.antMatchers("/member").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/member/add").permitAll()
				.antMatchers("/member/update").permitAll()
				.antMatchers("/member/getcodeverify").permitAll()
				.antMatchers("/member/getmemberbyemail").hasAnyRole("ADMIN","USER","STAFF")
				.antMatchers("/member/**").hasRole("ADMIN")
				
				.antMatchers("/employee").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/employee/getrole").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/employee/{status}").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/employee/**").hasRole("ADMIN")
				
				.antMatchers("/movie/getgenre").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/movie").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/movie/{status}").permitAll()
				.antMatchers("/movie/findbyid").permitAll()
				.antMatchers("/movie/findbyname").permitAll()
				.antMatchers("/movie/movieofweek").permitAll()
				.antMatchers("/movie/movieofmonth").permitAll()
				.antMatchers("/movie/findbygenre").permitAll()
				.antMatchers("/movie/getmoviebyshowtime").permitAll()
				.antMatchers("/movie/getgenre").permitAll()
				.antMatchers("/movie/**").hasRole("ADMIN")
				
				.antMatchers("/ticket").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/ticket/getticketbycinemaa").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/ticket/**").hasAnyRole("ADMIN", "USER")
				
				.antMatchers("/seat").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/seat/**").hasAnyRole("ADMIN","STAFF")	
				
				.antMatchers("/room").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/room/**").hasRole("ADMIN")
				
				.antMatchers("/seatstatus/**").permitAll()
				
				.antMatchers("/period").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/period/**").hasRole("ADMIN")
				
				.antMatchers("/genre").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/genre/**").hasRole("ADMIN")
				
				.antMatchers("/food").hasAnyRole("ADMIN","STAFF")
				.antMatchers("/food/{status}").permitAll()
				.antMatchers("/food/findbyname").permitAll()
				.antMatchers("/food/**").hasRole("ADMIN")
				
				.antMatchers("/showtimes/{status}").permitAll()
				.antMatchers("/showtimes/findbyid").permitAll()
				.antMatchers("/showtimes/getshowtimesbycinema").permitAll()
				.antMatchers("/showtimes/getshowtimesbymovieid").permitAll()
				.antMatchers("/showtimes/**").hasRole("ADMIN")
				
				.antMatchers("/view/historytrans").hasRole("USER")
				.antMatchers("/view/**").hasAnyRole("ADMIN","STAFF")

				.antMatchers("/login").authenticated() 
				.antMatchers("/**").permitAll()
				.and().httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
