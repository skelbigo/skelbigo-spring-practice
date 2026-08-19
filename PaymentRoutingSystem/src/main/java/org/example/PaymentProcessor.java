package org.example;

import java.math.BigDecimal;

public interface PaymentProcessor {
    String getName();
    void process(BigDecimal amount);
}
