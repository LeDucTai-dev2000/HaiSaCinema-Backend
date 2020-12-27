package com.DTO;

import java.sql.Date;
import java.util.List;

import com.Entity.Member;
import com.Entity.Role;
import com.Entity.Ticket;
import com.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberDTO {
	private Integer memberId;
	private String memberName;
	private String email;
	private String password;
	private String phone;
	private String address;
	private Date birthday;
	private String idCard;
	private Double totalMoney;

	public MemberDTO() {
		super();
	}

	public MemberDTO(Integer memberId, String memberName, String email, String password, String phone, String address,
			Date birthday, String idCard, Double totalMoney ) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.idCard = idCard;
		this.totalMoney = totalMoney;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(memberName) || isNull(phone);
		return includeId ? res || isNull(memberId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}


	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}


	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + ", birthday=" + birthday + ", idCard="
				+ idCard + ", totalMoney=" + totalMoney +"]";
	}
}
