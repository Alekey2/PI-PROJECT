package br.com.stock.resources.exceptionHandlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.stock.DTO.AppExceptionsDTO;
import br.com.stock.exceptions.AppExceptions;

@RestControllerAdvice
public class StockResourceAdvice {

	@ExceptionHandler(AppExceptions.class)
	public ResponseEntity<AppExceptionsDTO> handleAppExceptions(AppExceptions appExceptions) {
		return ResponseEntity.status(appExceptions.getStatusCode()).body(new AppExceptionsDTO(appExceptions.getMessages(), appExceptions.getDescription(), appExceptions.getStatusCode(), appExceptions.getExceptionAt()));
	}
	
}
