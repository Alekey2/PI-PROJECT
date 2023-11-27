package br.com.stock.exceptions.specialization;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.stock.exceptions.AppExceptions;

public class StockAlreadyExists extends AppExceptions {

	private static final long serialVersionUID = 1L;
	
	public StockAlreadyExists(List<String> message, String description) {
		super(message, description, HttpStatus.CONFLICT, LocalDateTime.now());
	}

	public StockAlreadyExists(String messages, String description) {
		super(messages, description, HttpStatus.CONFLICT, LocalDateTime.now());
	}
	
}
