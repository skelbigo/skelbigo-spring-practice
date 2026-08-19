package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}
