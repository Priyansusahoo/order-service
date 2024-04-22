package com.priyansu.orderservice.service;

import com.priyansu.orderservice.dto.OrderRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IOrderService {
    public ResponseEntity<Boolean> placeOrder(@RequestBody OrderRequestDto orderRequest);
}
