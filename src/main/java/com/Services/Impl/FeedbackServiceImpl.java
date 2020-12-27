package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.FeedbackDTO;
import com.Entity.Feedback;

import com.Repository.FeedbackRepository;
import com.Services.FeedbackService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepository repository;

	@Override
	public List<Feedback> getAll() {
		return repository.findAll();
	}

	@Override
	public Feedback add(Feedback feedback) {
		return repository.save(feedback);
	}

	@Override
	public Feedback save(Feedback feedback) {
		return repository.saveAndFlush(feedback);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public List<Feedback> addAll(List<Feedback> list) {
		List<Feedback> res = new ArrayList<>();
		for (Feedback feedback : list) {
			res.add(add(feedback));
		}
		return res;

	}

	@Override
	public Feedback convertToFeedback(FeedbackDTO dto) {
		Feedback feedback = new Feedback();
		feedback.setEmail(dto.getEmail());
		feedback.setContent(dto.getContent());
		feedback.setPhone(dto.getPhone());
		return feedback;
	}

}
