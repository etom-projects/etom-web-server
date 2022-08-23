package com.kurly.delivery.domain.product.repository;

import com.kurly.delivery.domain.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
