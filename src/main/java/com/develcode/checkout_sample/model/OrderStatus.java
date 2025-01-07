package com.develcode.checkout_sample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PENDING,
    COMPLETED,
    FAILED,
    CANCELED;

    @JsonCreator
    public static OrderStatus fromValue(String value) {
        return OrderStatus.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
