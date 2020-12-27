package com.Services;

import java.util.List;

import com.DTO.view.CinemaShowtimeViewDTO;
import com.DTO.view.GenreMovieView;
import com.DTO.view.HistoryTransView;
import com.DTO.view.HistoryTransViewDTO;
import com.DTO.view.TopMovieView;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.DTO.view.TotalByCinemaView;
import com.DTO.view.TotalMemberFeedbackMovieTicket;

public interface ViewService {
	/**
	 * The function that get Ticket's quantity of showtime by cinema
	 * 
	 * @return List<TicketByShowtimeView>
	 */
	List<TicketByShowtimeView> getTicketByShowtime(Integer cinemaId);

	/**
	 * The function that get Ticket's quantity by movie
	 * 
	 * @return List<TicketByMovieView>
	 */
	List<TicketByMovieView> getTicketByMovie(Integer status);

	/**
	 * The function that get Ticket's quantity of month by movie
	 * 
	 * @return List<TicketByMovieView>
	 */
	List<TicketByMovieView> getTicketOfMonthByMovie(Integer month);

	/**
	 * The function that get total money of month by Cinema
	 * 
	 * @return List<TotalByCinemaView>
	 */
	List<TotalByCinemaView> getTotalOfMonthByCinema(Integer cinemaId);

	/**
	 * The function that get total money by Cinema
	 * 
	 * @return List<TotalByCinemaView>
	 */
	List<TotalByCinemaView> getTotalByCinema();

	/**
	 * The function that get all Genre by Movie.movieId
	 * 
	 * @return List<GenreMovieView> - include movieName & genreName
	 */
	List<GenreMovieView> getGenreByMovieId(Integer id);

	/**
	 * The function that get all Ticket bought by Member
	 * 
	 * @param id - memberId
	 * @return List<HistoryTransView> - include movieName & genreName
	 */
	List<HistoryTransView> getTicketBought(Integer id);

	/**
	 * Convert from HistoryTransView to HistoryTransViewDTO
	 * 
	 * @return HistoryTransViewDTO
	 */
	HistoryTransViewDTO convertToDtos(HistoryTransView historyTransView);

	/**
	 * The function that get 5 Movie have the most Ticket bought of week
	 * 
	 * @return List<TopMovieView>
	 */
	List<TopMovieView> getMovieOfWeek();

	/**
	 * The function that get 5 Movie have the most Ticket bought of month
	 * 
	 * @return List<TopMovieView>
	 */
	List<TopMovieView> getMovieOfMonth();

	/**
	 * The function that get Total of Member,FeedBack,Movie,Ticket of all Cinema 
	 * 
	 * @return TotalMemberFeedbackMovieTicket
	 */
	TotalMemberFeedbackMovieTicket getTotalMemberFeedbackMovieTicket();
	
	List<CinemaShowtimeViewDTO> getCinemaShowtimeView();

	/**
	 * The function that return ROLE_NAME, search by email of User
	 * 
	 * @return List<String> ROLE_NAME
	 */
	List<String> getRole(String email);

}
