package com.DTO.view;

import java.sql.Date;
import java.util.List;

import com.Entity.Seat;

public interface HistoryTransView {
	
	Integer getticketId();

	String getmemberName();

	Integer getticketQuantity();

	Double gettotal();

	String getmovieName();

	String getemployeeName();

	Date getDate();

	String getcinemaName();

	String getroom();
	
	String getshowtime();
	
	Double getticketPrice();
	
	Double getfoodPrice();
	
	List<String> getseats();
}
