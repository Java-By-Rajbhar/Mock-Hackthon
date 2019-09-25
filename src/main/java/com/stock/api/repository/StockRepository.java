package com.stock.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.api.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

	Optional<Stock> findByStockId(Integer stockId);

}
