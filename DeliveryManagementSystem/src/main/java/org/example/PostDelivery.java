package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class PostDelivery implements DeliveryMethod {
    @Override
    public String delivery() {
        return "POST";
    }
}
