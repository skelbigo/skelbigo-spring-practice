package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartHouseService {
    @Value("${app.house}")
    private String houseName;

    private final List<Device> devices;

    public SmartHouseService(List<Device> devices) {
        this.devices = devices;
    }

    public void startHome() {
        System.out.println("\nHouse: " + houseName);
        for (Device device : devices) {
            device.start();
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("SmartHouseService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SmartHouseService destroyed");
    }
}
