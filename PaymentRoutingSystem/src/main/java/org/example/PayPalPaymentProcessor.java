package org.example;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public void process(BigDecimal amount) {
        System.out.println("Processing " + amount + " via PayPal.");
    }
}
