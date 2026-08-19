package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    static void main() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.sendReceipt(new BigDecimal("100.00"));
        try {
            orderService.sendReceipt(new BigDecimal(-250));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        AsyncLogService asyncLogService = applicationContext.getBean(AsyncLogService.class);
        asyncLogService.callInternal();
        applicationContext.close();

    }
}
