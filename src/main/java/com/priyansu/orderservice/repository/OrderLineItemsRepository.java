package com.priyansu.orderservice.repository;

import com.priyansu.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Priyansu Sahoo
 * 21-04-2024
 * @Project order-service
 */
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Long> {
}
