package com.develcode.checkout_sample.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDER_PAY")
public class OrderPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String items;
}
