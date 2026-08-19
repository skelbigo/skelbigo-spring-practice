package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            NotificationService notificationService = applicationContext.getBean(NotificationService.class);
            notificationService.sendNotification();
            notificationService.sendNotification();
            notificationService.sendNotification();
        }
    }
}
