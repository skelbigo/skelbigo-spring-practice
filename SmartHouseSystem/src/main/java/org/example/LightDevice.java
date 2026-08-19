package org.example;

public class LightDevice implements Device {
    @Override
    public void start() {
        System.out.println("LIGHT started");
    }
}
