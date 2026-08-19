package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class CardPaymentService implements PaymentService {
    @Override
    public void processPayment() {
        System.out.println("Payment: CARD");
    }
}
