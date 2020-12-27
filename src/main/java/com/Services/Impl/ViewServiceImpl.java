package com.Services.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.view.CinemaShowtimeViewDTO;
import com.DTO.view.DatePeriodDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.HistoryTransViewDTO;
import com.DTO.view.ShowtimePeriodDTO;
import com.DTO.view.TopMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.DTO.view.TotalMemberFeedbackMovieTicket;
import com.Entity.Movie;
import com.Entity.Period;
import com.Repository.CinemaRepository;
import com.Repository.FeedbackRepository;
import com.Repository.MemberRepository;
import com.Repository.MovieRepository;
import com.Repository.PeriodRepository;
import com.Repository.ShowtimesRepository;
import com.Repository.TicketRepository;
import com.Repository.ViewRepository;
import com.Services.ViewService;

@Service
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewRepository repository;
	@Autowired
	ShowtimesRepository showtimesRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	PeriodRepository periodRepository;

	@Override
	public List<TicketByShowtimeView> getTicketByShowtime(Integer cinemaId) {
		return repository.getTicketByShowtime(cinemaId);
	}

	@Override
	public List<TicketByMovieView> getTicketOfMonthByMovie(Integer month) {
		Date date = new Date();
		Integer year = date.getYear() + 1900;
		return repository.getTicketOfMonthByMovie(month, year);
	}

	public List<TicketByMovieView> getTicketByMovie(Integer status) {
		return repository.getTicketByMovie(status);
	}

	@Override
	public List<TotalByCinemaView> getTotalOfMonthByCinema(Integer cinemaId) {
		return repository.getTotalOfMonthByCinema(cinemaId);
	}

	@Override
	public List<TotalByCinemaView> getTotalByCinema() {
		return repository.getTotalByCinema();
	}

	@Override
	public List<GenreMovieView> getGenreByMovieId(Integer id) {
		return repository.getGenreByMovieId(id);

	}

	@Override
	public List<HistoryTransView> getTicketBought(Integer id) {
		return repository.getTicketBought(id);
	}

	@Override
	public HistoryTransViewDTO convertToDtos(HistoryTransView historyTransView) {
		HistoryTransViewDTO dto = new HistoryTransViewDTO();
		dto.setTicketId(historyTransView.getticketId());
		dto.setMemberName(historyTransView.getmemberName());
		dto.setTicketQuantity(historyTransView.getticketQuantity());
		dto.setTotal(historyTransView.gettotal());
		dto.setMovieName(historyTransView.getmovieName());
		dto.setEmployeeName(historyTransView.getemployeeName());
		dto.setDate(historyTransView.getDate());
		dto.setCinemaName(historyTransView.getcinemaName());
		dto.setRoom(historyTransView.getroom());
		dto.setShowtime(historyTransView.getshowtime());
		dto.setTicketPrice(historyTransView.getticketPrice());
		dto.setFoodPrice(historyTransView.getfoodPrice());
		return dto;
	}

	@Override
	public List<TopMovieView> getMovieOfWeek() {
		Date dateNow = new Date();
		long msOfNow = dateNow.getTime();
		Date date = new Date(msOfNow - 604800000);
		return repository.getTopMovie(dateNow, date);
	}

	@Override
	public List<TopMovieView> getMovieOfMonth() {
		Date dateNow = new Date();
		long msOfNow = dateNow.getTime();
		Date date = new Date(msOfNow - 2629800000L);
		return repository.getTopMovie(dateNow, date);
	}

	@Override
	public TotalMemberFeedbackMovieTicket getTotalMemberFeedbackMovieTicket() {
		TotalMemberFeedbackMovieTicket total = new TotalMemberFeedbackMovieTicket();
		total.setMember(memberRepository.totalMember());
		total.setFeedback(feedbackRepository.totalFeedback());
		total.setMovie(movieRepository.totalMovie());
		total.setTicket(ticketRepository.totalTicket());
		return total;
	}

	@Override
	public List<String> getRole(String email) {
		return repository.getRole(email);
	}

	@Override
	public List<CinemaShowtimeViewDTO> getCinemaShowtimeView() {
		List<CinemaShowtimeViewDTO> listCinemaShowtimeView = new ArrayList<>();

		Date date = new Date();
		Long nextDateTime = date.getTime() + 604800000;
		Date nextDate = new Date(nextDateTime);

		List<Integer> listCinemaId = repository.findCinemaByDateOfShowtime(date, nextDate);
		for (Integer cinemaId : listCinemaId) {
			CinemaShowtimeViewDTO cinemaShowtimeViewDTO = new CinemaShowtimeViewDTO();
			cinemaShowtimeViewDTO.setCinema(cinemaRepository.findById(cinemaId).orElse(null));
			List<DatePeriodDTO> listDatePeriodDTO = new ArrayList<>();

			List<Date> listDate = repository.findDateByCinemaShowtime(date, nextDate, cinemaId);
			for (Date dateShowtime : listDate) {
				DatePeriodDTO datePeriodDTO = new DatePeriodDTO();
				datePeriodDTO.setDate(dateShowtime);
				List<ShowtimePeriodDTO> listShowtimePeriodDTO = new ArrayList<>();

				List<Integer> listPeriodId = repository.findPeriodShowtimeByCinemaDate(cinemaId, dateShowtime);
				for (Integer periodId : listPeriodId) {
					ShowtimePeriodDTO showtimePeriodDTO = new ShowtimePeriodDTO();
					Period period = periodRepository.findById(periodId).orElse(null);
					showtimePeriodDTO.setPeriodId(period.getPeriodId());
					showtimePeriodDTO.setStartTime(period.getStartTime());
					showtimePeriodDTO.setStatusDay(period.getStatusDay());
					showtimePeriodDTO.setPrice(period.getPrice());

					List<Integer> listMovieId = repository.findMovieByShowtimePeriodCinemaDate(cinemaId, dateShowtime,
							periodId);
					List<Movie> listMovie = new ArrayList<>();
					for (Integer movieId : listMovieId) {
						Movie movie = movieRepository.findById(movieId).orElse(null);
						listMovie.add(movie);
					}

					showtimePeriodDTO.setMovies(listMovie);
					listShowtimePeriodDTO.add(showtimePeriodDTO);
				}
				datePeriodDTO.setPeriods(listShowtimePeriodDTO);
				listDatePeriodDTO.add(datePeriodDTO);
			}
			cinemaShowtimeViewDTO.setDatePeriodDTO(listDatePeriodDTO);
			listCinemaShowtimeView.add(cinemaShowtimeViewDTO);
		}
		return listCinemaShowtimeView;
	}

}
