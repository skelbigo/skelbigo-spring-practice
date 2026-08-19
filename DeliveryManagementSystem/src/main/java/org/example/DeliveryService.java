package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DeliveryService {
    @Value("${app.company}")
    private String companyName;
    private final DeliveryMethod deliveryMethod;
    private final ObjectProvider<TrackingIdGenerator> trackingIdGeneratorProvider;
    private final DeliveryPriceCalculator priceCalculator;

    private InsuranceService insuranceService;

    public DeliveryService(DeliveryMethod deliveryMethod, ObjectProvider<TrackingIdGenerator> trackingIdGeneratorProvider, DeliveryPriceCalculator priceCalculator) {
        this.deliveryMethod = deliveryMethod;
        this.trackingIdGeneratorProvider = trackingIdGeneratorProvider;
        this.priceCalculator = priceCalculator;
    }

    @Autowired(required = false)
    public void setInsuranceService(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    public void processDelivery(String recipient, String address, double weight) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient can not be null or empty!");
        }

        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address can not be null or empty!");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0!");
        }

        TrackingIdGenerator idGenerator = trackingIdGeneratorProvider.getObject();
        BigDecimal basePrice = priceCalculator.calculate(weight);
        BigDecimal insurance = BigDecimal.ZERO;

        if (this.insuranceService != null) {
            insurance = this.insuranceService.calculateInsurance(basePrice);
        }

        BigDecimal finalPrice = basePrice.add(insurance);
        System.out.println("Tracking: " + idGenerator.generateId());
        System.out.println("Company: " + companyName);
        System.out.println("Recipient: " + recipient);
        System.out.println("Address: " + address);
        System.out.println("Weight: " + weight);
        System.out.println("Delivery: " + deliveryMethod.delivery());
        System.out.println("Base price: " + basePrice);
        System.out.println("Insurance: " + insurance);
        System.out.println("Final price: " + finalPrice);
    }

    @PostConstruct
    public void init() {
        System.out.println("DeliveryService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DeliveryService destroyed");
    }
}
