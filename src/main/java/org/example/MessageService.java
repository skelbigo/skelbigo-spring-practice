package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${app.name}")
    private String name;

    @Value("${app.greeting}")
    private String greeting;

    public String generateGreeting() {
        return greeting + ", " + name;
    }
}
