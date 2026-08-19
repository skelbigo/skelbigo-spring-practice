package org.example;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CryptoPaymentProcessor implements PaymentProcessor {
    @Override
    public String getName() {
        return "Cryptocurrency";
    }

    @Override
    public void process(BigDecimal amount) {
        System.out.println("Processing " + amount + " via Crypto Wallet.");
    }
}
