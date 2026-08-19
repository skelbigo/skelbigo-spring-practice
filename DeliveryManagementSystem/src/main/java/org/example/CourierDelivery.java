package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class CourierDelivery implements DeliveryMethod {
    @Override
    public String delivery() {
        return "COURIER";
    }
}
