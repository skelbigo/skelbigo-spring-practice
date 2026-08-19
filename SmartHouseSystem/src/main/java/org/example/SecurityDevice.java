package org.example;

public class SecurityDevice implements Device {
    @Override
    public void start() {
        System.out.println("SECURITY started");
    }
}
