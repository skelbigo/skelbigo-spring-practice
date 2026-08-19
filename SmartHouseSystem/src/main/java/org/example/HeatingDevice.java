package org.example;

public class HeatingDevice implements Device {
    @Override
    public void start() {
        System.out.println("HEATING started");
    }
}
