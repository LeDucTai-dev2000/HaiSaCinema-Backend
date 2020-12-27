package com.Services;

import com.DTO.MemberDTO;
import com.Entity.Member;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
	/**
	 * Find all entity Member
	 * 
	 * @return List<Member>
	 */
	List<Member> getAll();

	/**
	 * Delete all entity Member already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves a entity Member
	 * 
	 * @return entity Member
	 */
	Member add(Member member);

	/**
	 * Saves all entity Member from list Member
	 * 
	 * @return List<Member>
	 */
	List<Member> addAll(List<Member> list);

	/**
	 * Search an entity Member by its id
	 * 
	 * @return the entity with the MemberId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Member> findById(Integer id);

	/**
	 * Search list Member with the same name(memberName) entered
	 * 
	 * @return List<Member>
	 */
	List<Member> findByName(String name);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Member
	 */
	Member save(Member member);

	/**
	 * Convert from EmployeeDTO to entity Employee
	 * 
	 * @return entity Employee
	 */
	Member convertToMember(MemberDTO memberDTO);

	/**
	 * Find an entity Member by email entered
	 * 
	 * @return Member
	 */
	Member getMemberByEmail(String email);
}
