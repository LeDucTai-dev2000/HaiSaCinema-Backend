package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.Repository.SeatStatusRepository;
import com.Repository.ShowtimesRepository;
import com.Services.SeatStatusService;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {
	@Autowired
	SeatStatusRepository repository;
	@Autowired
	ShowtimesRepository showtimesRepository;

	@Override
	public Showtimes add(Showtimes showtimes) {
		List<Seat> seatList = showtimes.getRoom().getSeat();
		for(Seat seat : seatList) {
			SeatStatus seatStatus = new SeatStatus();
			seatStatus.setShowtimes(showtimes);
			seatStatus.setSeat(seat);
			seatStatus.setStatus(false);
			repository.save(seatStatus);
		}
		return showtimesRepository.findByShowtimesId(showtimes.getShowtimeId()).get();
	}

	@Override
	public SeatStatus save(SeatStatus seatStatus) {
		return repository.saveAndFlush(seatStatus);
	}

	@Override
	public Optional<SeatStatus> findById(Integer seatStatusId) {
		return repository.findById(seatStatusId);
	}

	@Override
	public List<SeatStatus> findAllByShowtimeId(Integer showtimeId) {
		Showtimes showtimes = showtimesRepository.findById(showtimeId).orElse(null);
		return repository.findByShowtimes(showtimes);
	}

}
