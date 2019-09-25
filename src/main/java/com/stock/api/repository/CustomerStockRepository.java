package com.stock.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.entity.CustomerStock;
@Repository
public interface CustomerStockRepository extends JpaRepository<CustomerStock, Integer> {

	Optional<List<CustomerStock>> findByCustomerId(Integer customerId);
	

}
