package com.priyansu.orderservice.service;

import com.priyansu.orderservice.dto.OrderLineItemsDto;
import com.priyansu.orderservice.dto.OrderRequestDto;
import com.priyansu.orderservice.model.OrderLineItems;
import com.priyansu.orderservice.model.Orders;
import com.priyansu.orderservice.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements IOrderService{

    private final OrdersRepository ordersRepository;

    public ResponseEntity<Boolean> placeOrder(OrderRequestDto orderRequest){
        try {
            if (!orderRequest.getOrderLineItemsDtoList().isEmpty()) {
                Orders orders = new Orders();
                orders.setOrderNumber(UUID.randomUUID().toString());

                List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                        .stream()
                        .map(this::mapLineItemsToDto)
                        .toList();

                orders.setOrderLineItemsList(orderLineItemsList);
                ordersRepository.save(orders);
                log.info("Order with ORDER-ID : {} and ORDER-NUMBER : {} placed successfully", orders.getId(), orders.getOrderNumber());
                return ResponseEntity.ok(Boolean.TRUE);
            }
            log.error("**********ERROR********** " + " orderLineItemsDtoList is empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        } catch (Exception e) {
            log.error("**********ERROR IN EXCEPTION ********** " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
        }
    }

    public OrderLineItems mapLineItemsToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }
}
