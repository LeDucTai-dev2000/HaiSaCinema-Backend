package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "userRole", uniqueConstraints = { @UniqueConstraint(columnNames = { "roleid", "userid" }) })
public class UserRole {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userRoleid", unique = true, nullable = false)
	private Integer userRoleId;

	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	public UserRole() {
		super();
	}

	public UserRole(Integer userRoleId, Role role, User user) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
		this.user = user;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "userRole [userRoleId=" + userRoleId + ", role=" + getUser().getUserRole() + "]";
	}

}
