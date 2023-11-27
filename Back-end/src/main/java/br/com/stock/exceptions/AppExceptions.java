package br.com.stock.exceptions;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

public class AppExceptions extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> messages;
	private String description;
	private HttpStatus statusCode;
	private LocalDateTime exceptionAt;
	
	public AppExceptions(String messages, String description, HttpStatus statusCode, LocalDateTime exceptionAt) {
		this.messages = Collections.singletonList(messages);
		this.description = description;
		this.statusCode = statusCode;
		this.exceptionAt = exceptionAt;
	}

	public AppExceptions(List<String> message, String description, HttpStatus statusCode, LocalDateTime exceptionAt) {
		this.messages = message;
		this.description = description;
		this.statusCode = statusCode;
		this.exceptionAt = exceptionAt;
	}

	public List<String> getMessages() {
		return messages;
	}

	public String getDescription() {
		return description;
	}

	private void updateDescription(String description) {
		this.setDescription(description);;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void updateStatusCode(HttpStatus statusCode) {
		this.setStatusCode(statusCode);;
	}

	private void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getExceptionAt() {
		return exceptionAt;
	}

	public void updateExceptionAt(LocalDateTime exceptionAt) {
		this.setExceptionAt(exceptionAt);;
	}

	private void setExceptionAt(LocalDateTime exceptionAt) {
		this.exceptionAt = exceptionAt;
	}
	
}
