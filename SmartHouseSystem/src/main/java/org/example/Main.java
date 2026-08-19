package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SmartHouseService smartHouse = applicationContext.getBean(SmartHouseService.class);
        smartHouse.startHome();
        System.out.println("\nRequesting heavy scanner...");
        applicationContext.getBean(HeavySecurityScanner.class);
        applicationContext.close();
    }
}
