package com.priyansu.orderservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long id;
    @JsonProperty("orderNumber")
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderLineItems> orderLineItemsList;
}
