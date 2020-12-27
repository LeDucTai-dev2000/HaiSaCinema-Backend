package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query(value = "SELECT m FROM Member m WHERE m.memberName LIKE %:name%")
	List<Member> findByMemberName(String name);

	@Query(value = "SELECT COUNT(m) FROM Member m")
	Integer totalMember();

	@Query(value = "SELECT m FROM  Member m WHERE m.user.email = :email ")
	Member getMemberByEmail(String email);
}
