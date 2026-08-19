package org.example;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InsuranceService {
    public BigDecimal calculateInsurance(BigDecimal basePrice) {
        return basePrice.multiply(new BigDecimal("0.05"));
    }
}
