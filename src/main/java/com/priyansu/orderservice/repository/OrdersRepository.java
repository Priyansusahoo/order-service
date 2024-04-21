package com.priyansu.orderservice.repository;

import com.priyansu.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Priyansu Sahoo
 * 21-04-2024
 * @Project order-service
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
