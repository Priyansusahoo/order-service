package com.priyansu.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Priyansu Sahoo
 * 20-04-2024
 * @Project order-service
 */
@Entity
@Table(name = "t_order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
