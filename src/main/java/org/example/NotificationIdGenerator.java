package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class NotificationIdGenerator {
    private final int id;

    public NotificationIdGenerator() {
        this.id = new Random().nextInt();
    }

    public int getId() {
        return id;
    }
}
