package br.com.stock.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import br.com.stock.Stock;
import br.com.stock.repositories.StockRepository;

@Configuration
@Service
public class DBService {
	@Autowired
	private StockRepository stockRepository;
	
	@Bean
	public void instanciarDB() {
		Stock estoque = new Stock(0, "Celular", 2.500, 2.000, "Smartphone da Xiaomi");
		stockRepository.saveAll(Arrays.asList(estoque));
	}
}
