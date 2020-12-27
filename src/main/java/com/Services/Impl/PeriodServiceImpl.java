package com.Services.Impl;

import com.Entity.Period;
import com.Entity.Showtimes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Repository.PeriodRepository;
import com.Services.PeriodService;

@Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	PeriodRepository repository;

	@Override
	public List<Period> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Period add(Period period) {
		return repository.save(period);
	}

	@Override
	public List<Period> addAll(List<Period> list) {
		List<Period> res = new ArrayList<>();
		for (Period period : list) {
			res.add(add(period));
		}
		return res;
	}

	@Override
	public Optional<Period> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Period> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Period save(Period period) {
		return repository.saveAndFlush(period);
	}

	@Override
	public List<Period> findPeriodByStatus(Integer status) {
		return repository.findPeriodByStatus(status);
	}

}
