package com.develcode.checkout_sample.repository;

import com.develcode.checkout_sample.model.OrderPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPay, Long> {
}
