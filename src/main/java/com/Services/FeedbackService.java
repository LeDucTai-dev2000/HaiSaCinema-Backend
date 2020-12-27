package com.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.DTO.FeedbackDTO;
import com.Entity.Feedback;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public interface FeedbackService {
	/**
	 * The function that get all of the Feedback already exist
	 * 
	 * @return List<Feedback>
	 */
	List<Feedback> getAll();

	/**
	 * Saves a Feedback entity.
	 * 
	 * @return entity Feedback
	 */
	Feedback add(Feedback feedback);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Feedback
	 */
	Feedback save(Feedback feedback);

	/**
	 * Delete all column from table Cinema
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves the list Feedback
	 * 
	 * @return List<Feedback>
	 */
	List<Feedback> addAll(List<Feedback> list);

	/**
	 * Convert from	FeedbackDTO to entity Feedback
	 * 
	 * @return entity Feedback
	 */
	Feedback convertToFeedback(FeedbackDTO dto);

}
