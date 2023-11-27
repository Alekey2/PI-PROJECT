package br.com.stock.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.stock.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	Optional<Stock> findByNome(String nome);

}
