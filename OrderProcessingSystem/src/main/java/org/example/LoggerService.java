package org.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    @Async
    public void logAsync() {
        System.out.println("Async method thread: " + Thread.currentThread().getName());
    }
}
