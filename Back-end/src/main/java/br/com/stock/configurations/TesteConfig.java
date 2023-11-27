package br.com.stock.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.stock.services.DBService;

@Configuration
@Profile("Desenv")
public class TesteConfig {
	@Autowired
	DBService dbService;
	
	private boolean instaciar() throws Exception{
		this.dbService.instanciarDB();
		return true;
	}

}
