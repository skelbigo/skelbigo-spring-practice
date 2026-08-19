package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {
    @Value("${app.payment.system.name}")
    private String paymentSystemName;
    private final List<PaymentProcessor> allProcessors;
    private final PaymentProcessor defaultProcessor;

    public PaymentService(List<PaymentProcessor> allProcessors, @Qualifier("payPalPaymentProcessor") PaymentProcessor defaultProcessor) {
        this.allProcessors = allProcessors;
        this.defaultProcessor = defaultProcessor;
    }

    public void showAvailableProcessors() {
        System.out.println("Payment system: " + paymentSystemName);
        System.out.println("Available processors: ");
        for (PaymentProcessor paymentProcessor : allProcessors) {
            System.out.println(paymentProcessor.getName());
        }
    }

    public void payDefault(BigDecimal amount) {
        defaultProcessor.process(amount);
    }

    @PostConstruct
    public void init() {
        System.out.println("PaymentService initialized");
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("PaymentService destroyed");
    }
}
