package org.example;

import org.springframework.stereotype.Service;

@Service
public class AsyncLogService {
    private final LoggerService loggerService;

    public AsyncLogService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void callInternal() {
        System.out.println("Async method thread: " + Thread.currentThread().getName());
        loggerService.logAsync();
    }
}
