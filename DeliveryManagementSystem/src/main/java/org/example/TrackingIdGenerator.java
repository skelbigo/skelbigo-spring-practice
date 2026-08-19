package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class TrackingIdGenerator {
    public String generateId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
