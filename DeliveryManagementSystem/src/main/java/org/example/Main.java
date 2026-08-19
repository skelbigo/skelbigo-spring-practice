package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        DeliveryService deliveryService = applicationContext.getBean(DeliveryService.class);
        deliveryService.processDelivery("Oleksandra", "1 Khreshchatyk St.", 2.5);
        deliveryService.processDelivery("Oleksiy", "10 Naukov Street", 10.0);
        try {
            deliveryService.processDelivery("Valya", "" , -10.4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        applicationContext.close();
    }
}
