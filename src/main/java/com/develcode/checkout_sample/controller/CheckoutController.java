package com.develcode.checkout_sample.controller;

import com.develcode.checkout_sample.dto.ItemDTO;
import com.develcode.checkout_sample.model.OrderStatus;
import com.develcode.checkout_sample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody ItemDTO item) {
        return orderService.createOrder(item); //Return Response
    }

    @PutMapping("/order/{orderId}/status")
    public void updateStatus(@PathVariable Long orderId, @RequestBody String status) {
        orderService.updateStatus(orderId, status); //Return Response
    }
}
