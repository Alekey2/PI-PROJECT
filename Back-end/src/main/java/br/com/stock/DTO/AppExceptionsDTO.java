package br.com.stock.DTO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

public class AppExceptionsDTO {
	
	private List<String> messages;
	private String description;
	private HttpStatus statusCode;
	private LocalDateTime exceptionAt;
	
	public AppExceptionsDTO(String messages, String description, HttpStatus statusCode, LocalDateTime exceptionAt) {
		this.messages = Collections.singletonList(messages);
		this.description = description;
		this.statusCode = statusCode;
		this.exceptionAt = exceptionAt;
	}

	public AppExceptionsDTO(List<String> message, String description, HttpStatus statusCode, LocalDateTime exceptionAt) {
		this.messages = message;
		this.description = description;
		this.statusCode = statusCode;
		this.exceptionAt = exceptionAt;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getExceptionAt() {
		return exceptionAt;
	}

	public void setExceptionAt(LocalDateTime exceptionAt) {
		this.exceptionAt = exceptionAt;
	}
	
}
