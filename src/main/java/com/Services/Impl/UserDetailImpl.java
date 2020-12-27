//package com.Services.Impl;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import com.Entity.Users;
//
//public class UserDetailImpl implements UserDetails {
//	private String username;
//	private String password;
//	private List<GrantedAuthority> authorize;
//
//	public UserDetailImpl(Users user) {
//		this.username = user.getUsername();
//		this.password = user.getPassword();
//		this.authorize = Arrays.asList(new SimpleGrantedAuthority(user.getRoleId().getRoleName()));
//		// TODO Auto-generated constructor stub
//	}
//
//	public UserDetailImpl() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorize;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
