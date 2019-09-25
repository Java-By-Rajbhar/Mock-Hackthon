package com.stock.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByEmail(String emailId);

	Optional<Customer> findByCustomerId(Integer customerId);

}
