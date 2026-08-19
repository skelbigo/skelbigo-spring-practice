package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CashPaymentService implements PaymentService {
    @Override
    public void processPayment() {
        System.out.println("Payment: CASH");
    }
}
