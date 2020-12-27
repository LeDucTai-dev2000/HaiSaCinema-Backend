package com.DTO.view;

public class TotalMemberFeedbackMovieTicket {
	
	Integer member;
	Integer feedback;
	Integer movie;
	Integer ticket;
	public TotalMemberFeedbackMovieTicket() {
		super();
	}
	public TotalMemberFeedbackMovieTicket(Integer member, Integer feedback, Integer movie, Integer ticket) {
		super();
		this.member = member;
		this.feedback = feedback;
		this.movie = movie;
		this.ticket = ticket;
	}
	public Integer getMember() {
		return member;
	}
	public void setMember(Integer member) {
		this.member = member;
	}
	public Integer getFeedback() {
		return feedback;
	}
	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}
	public Integer getMovie() {
		return movie;
	}
	public void setMovie(Integer movie) {
		this.movie = movie;
	}
	public Integer getTicket() {
		return ticket;
	}
	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}
	
}
