package com.DTO;

import java.sql.Date;
import java.util.List;

import com.Entity.Cinema;
import com.Entity.Employee;
import com.Entity.Role;
import com.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDTO {
	private Integer employeeId;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;
	private Date birthday;
	private String idCard;
	private Integer cinemaId;
	private List<Role> listRole;
	private Integer status;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Integer employeeId, String name, String password, String email, String phone, String address,
			Date birthday, String idCard, Integer cinemaId, Integer status) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.idCard = idCard;
		this.cinemaId = cinemaId;
		this.status = status;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(name) || isNull(phone) || isNull(address);
		return includeId ? res || isNull(employeeId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

}
