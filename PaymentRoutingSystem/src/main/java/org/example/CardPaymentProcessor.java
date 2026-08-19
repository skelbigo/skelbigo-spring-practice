package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Primary
public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public String getName() {
        return "Credit/Debit card";
    }

    @Override
    public void process(BigDecimal amount) {
        System.out.println("Processing " + amount + " via Card.");
    }
}
