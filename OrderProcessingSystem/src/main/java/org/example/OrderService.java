package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final ReceiptService receiptService;
    private final PaymentService paymentService;
    private final ObjectProvider<OrderNumberGenerator> orderNumberProvider;
    private DiscountService discountService;

    public OrderService(ReceiptService receiptService, PaymentService paymentService, ObjectProvider<OrderNumberGenerator> orderNumberProvider) {
        this.receiptService = receiptService;
        this.paymentService = paymentService;
        this.orderNumberProvider = orderNumberProvider;
    }

    @Autowired(required = false)
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void sendReceipt(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Error: The order total must be greater than 0. Current total: " + amount);
        }
        BigDecimal finalAmount = amount;
        if (this.discountService != null) {
            finalAmount = discountService.applyDiscount(amount);
            System.out.println("Applied discount. Original amount: " + amount + ", new amount: " + finalAmount);
        }
        OrderNumberGenerator orderNumberGenerator = orderNumberProvider.getObject();
        receiptService.generateOrder(orderNumberGenerator, finalAmount);
        paymentService.processPayment();
    }

    @PostConstruct
    public void init() {
        System.out.println("OrderService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("OrderService destroyed");
    }
}
