package com.priyansu.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Priyansu Sahoo
 * 20-04-2024
 * @Project order-service
 */
@Entity
@Table(name = "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
