package com.kurly.delivery.domain.customer.repository;


import com.kurly.delivery.domain.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
