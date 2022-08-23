package com.kurly.delivery.domain.order.repository;

import com.kurly.delivery.domain.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
