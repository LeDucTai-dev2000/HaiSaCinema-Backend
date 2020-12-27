package com.DTO.Base;

import org.springframework.http.HttpStatus;

/**
 * @author Minh Hung the custom Response Entity API Use for common return model
 * @param <T> the generic Type of the response
 */
public class ResponseEntity<T> {

	private T data;
	private HttpStatus httpStatus;

	public T getData() {
		return data;
	}

	public ResponseEntity(T data) {
		this.data = data;
	}

	public ResponseEntity(T data, HttpStatus httpStatus) {
		this.data = data;
		this.httpStatus = httpStatus;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> ResponseEntity<T> body(T body) {
		return new ResponseEntity<>(body);
	}
	
	public static <T> ResponseEntity<T> bodyStatus(T body, HttpStatus httpStatus) {
		return new ResponseEntity<>(body, httpStatus);
	}


}
