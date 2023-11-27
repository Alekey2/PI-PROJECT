package br.com.stock.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stock.Stock;
import br.com.stock.exceptions.AppExceptions;
import br.com.stock.services.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockResource {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping
	public List<Stock> findAll(){
		List<Stock> estoque = stockService.findAll();
		return estoque;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Stock> findById(@PathVariable Integer id){
		Stock estoque = stockService.findById(id);
		return ResponseEntity.ok().body(estoque);
	}
	
	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<Stock> findByNome(@PathVariable String nome){
		Stock estoque = stockService.findByNome(nome);
		return ResponseEntity.ok().body(estoque);
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastraProduto(@RequestBody Stock estoque) throws AppExceptions {
		stockService.cadastraProduto(estoque);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(estoque.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}" )
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		stockService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}" )
	public ResponseEntity<Stock> update(@PathVariable Integer id, @RequestBody Stock estoque){
		Stock alterado = stockService.update(id, estoque);
		return ResponseEntity.ok().body(alterado);
	}
	
	
}
