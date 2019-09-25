package com.stock.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	Optional<Stock> findByStockId(Integer stockId);

	public Stock findByStockId(int stockId);

}
