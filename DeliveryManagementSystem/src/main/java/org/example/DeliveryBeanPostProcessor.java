package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.toLowerCase().contains("delivery")) {
            System.out.println("Bean initialized: " + beanName);
        }
        return bean;
    }
}
