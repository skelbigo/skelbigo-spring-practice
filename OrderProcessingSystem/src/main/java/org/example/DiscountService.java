package org.example;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountService {
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.90"));
    }
}
