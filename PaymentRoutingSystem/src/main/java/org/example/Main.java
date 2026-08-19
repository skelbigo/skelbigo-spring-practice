package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    static void main() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentService paymentService = applicationContext.getBean(PaymentService.class);
        paymentService.showAvailableProcessors();
        paymentService.payDefault(new BigDecimal("150.60"));
        applicationContext.close();
    }
}
