package com.priyansu.orderservice.controller;

import com.priyansu.orderservice.dto.OrderRequestDto;
import com.priyansu.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Boolean> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.placeOrder(orderRequestDto);
    }
}
