package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ReceiptService {
    @Value("${app.store}")
    private String store;

    public void generateOrder(OrderNumberGenerator orderNumberGenerator, BigDecimal amount) {
        System.out.println("Order: " + orderNumberGenerator.getOrderNumber());
        System.out.println("Store: " + store);
        System.out.println("Total: " + amount);
    }
}
