package br.com.stock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stock.Stock;
import br.com.stock.exceptions.specialization.StockAlreadyExists;
import br.com.stock.repositories.StockRepository;

@Service
public class StockService {
	@Autowired	
	StockRepository stockRepository;
	
	public Stock findById(Integer id) {
		Optional<Stock> estoque = stockRepository.findById(id);
		return estoque.orElse(null);
	}
	
	public Stock findByNome(String nome){
		Optional<Stock> estoque = stockRepository.findByNome(nome);
		return estoque.orElse(null);
	}
	
	public List<Stock> findAll(){
		return stockRepository.findAll();
	}
	
	public void cadastraProduto(Stock newStock) throws StockAlreadyExists {
		
		System.out.println(newStock);
		
		List<Stock> stockList = this.findAll();
		
		for(Stock stock : stockList) {
			if(newStock.getNome().equals(stock.getNome()) && newStock.getDescricao().equals(stock.getDescricao())) {
				throw new StockAlreadyExists("Este produto já está cadastrado.", "Você tentou inserir um produto que já está cadastrado em nosso sistema.");
			}
		}
		
		stockRepository.save(newStock);
	}
	
	public void deletar(Integer id) {
		stockRepository.deleteById(id);
	}
	
	public Stock update(Integer id, Stock estoque){
		Stock alterado = findById(id);
		if(alterado!=null)
		{
			alterado.setNome(estoque.getNome());
			alterado.setPreco(estoque.getPreco());
			alterado.setCusto(estoque.getCusto());
			alterado.setDescricao(estoque.getDescricao());
			return stockRepository.save(alterado);
		}
		return null;
	}
}
