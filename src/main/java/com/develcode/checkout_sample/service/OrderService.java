package com.develcode.checkout_sample.service;

import com.develcode.checkout_sample.dto.ItemDTO;
import com.develcode.checkout_sample.model.OrderPay;
import com.develcode.checkout_sample.model.OrderStatus;
import com.develcode.checkout_sample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<Map<String, Object>> createOrder(ItemDTO item) { //dto
        OrderPay order = new OrderPay();
        order.setStatus("PENDING"); //enum
        order.setItems(item.getItem());
        orderRepository.save(order);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getId());
        response.put("status", OrderStatus.PENDING);
        return ResponseEntity.ok(response);
    }

    public void updateStatus(Long orderId, String status) {
        OrderPay order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order);
    }
}
