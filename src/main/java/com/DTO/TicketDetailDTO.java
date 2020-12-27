package com.DTO;

import com.Entity.Seat;
import com.Entity.Ticket;
import com.Entity.TicketDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketDetailDTO {
	private Integer ticketDetatailId;
	private Integer ticketId;
	private Integer seatId;
	private Ticket ticket;
	private Seat seat;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(ticketId) || isNull(seatId);
		return includeId ? res || isNull(ticketDetatailId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public TicketDetail convertToCinema() {
		Seat seat = new Seat();
		seat.setSeatId(this.getSeatId());
		this.setSeat(seat);
		Ticket ticket = new Ticket();
		ticket.setTicketId(this.getTicketId());
		this.ticket = ticket;
		ObjectMapper mapper = new ObjectMapper();
		TicketDetail ticketDetail = mapper.convertValue(this, TicketDetail.class);
		return ticketDetail;
	}

	public TicketDetailDTO() {

	}

	public TicketDetailDTO(Integer ticketDetatailId, Ticket ticket, Seat seat) {
		super();
		this.ticketDetatailId = ticketDetatailId;
		this.ticket = ticket;
		this.seat = seat;
	}

	public Integer getTicketDetatailId() {
		return ticketDetatailId;
	}

	public void setTicketDetatailId(Integer ticketDetatailId) {
		this.ticketDetatailId = ticketDetatailId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	@Override
	public String toString() {
		return "TicketDetailDTO [ticketDetatailId=" + ticketDetatailId + ", ticket=" + ticket + ", seat=" + seat + "]";
	}

}
