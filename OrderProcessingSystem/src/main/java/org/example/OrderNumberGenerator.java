package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class OrderNumberGenerator {
    private final int orderNumber;

    public OrderNumberGenerator() {
        this.orderNumber = new Random().nextInt();
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
