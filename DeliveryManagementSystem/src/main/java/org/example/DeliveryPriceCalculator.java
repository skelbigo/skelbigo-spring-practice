package org.example;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DeliveryPriceCalculator {
    public BigDecimal calculate(double weight) {
        BigDecimal base = new BigDecimal("50");
        BigDecimal weightCost = new BigDecimal("15").multiply(BigDecimal.valueOf(weight));
        return base.add(weightCost);
    }
}
