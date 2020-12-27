package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "[user]")
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	private Integer userId;

	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRole;

	
	@Override
	public String toString() {
		return "user [userId=" + userId + ", email=" + email + ",password="+password+"]";
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<UserRole> getUserRole() {
		return userRole;
	}


	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	

}
