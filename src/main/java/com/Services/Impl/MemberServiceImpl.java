package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.MemberDTO;
import com.Entity.Member;
import com.Entity.User;
import com.Repository.MemberRepository;
import com.Repository.UserRepository;
import com.Services.MemberService;
import com.Services.UserService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository repository;
	
	@Autowired
	UserService userService;

	public List<Member> getAll() {
		return repository.findAll();
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Member add(Member member) {
		return repository.save(member);
	}

	public List<Member> addAll(List<Member> list) {
		List<Member> res = new ArrayList<>();
		for (Member member : list) {
			res.add(add(member));
		}
		return res;
	}

	public Optional<Member> findById(Integer id) {
		return repository.findById(id);
	}

	public List<Member> findByName(String name) {
		return repository.findByMemberName(name);
	}

	public Member save(Member member) {
		return repository.saveAndFlush(member);
	}

	@Override
	public Member convertToMember(MemberDTO memberDTO) {
		Member member = new Member();
		member.setMemberId(memberDTO.getMemberId());
		member.setMemberName(memberDTO.getMemberName());
		member.setAddress(memberDTO.getAddress());
		member.setBirthday(memberDTO.getBirthday());
		member.setIdCard(memberDTO.getIdCard());
		member.setPhone(memberDTO.getPhone());
		member.setTotalMoney(memberDTO.getTotalMoney());
		return member;
	}

	@Override
	public Member getMemberByEmail(String email) {
		return repository.getMemberByEmail(email);
	}
}
