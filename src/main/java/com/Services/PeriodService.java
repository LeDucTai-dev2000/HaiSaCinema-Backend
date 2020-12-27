package com.Services;

import com.Entity.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface PeriodService {

	List<Period> getAll();

	void deleteAll();

	Period add(Period period);

	List<Period> addAll(List<Period> list);

	Optional<Period> findById(Integer id);

	List<Period> findByName(String name);

	Period save(Period period);

	List<Period> findPeriodByStatus(Integer status);
}
