package org.example;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public Device lightDevice() {
        return new LightDevice();
    }

    @Bean
    public Device heatingDevice() {
        return new HeatingDevice();
    }

    @Bean
    public Device securityDevice() {
        return new SecurityDevice();
    }

    @Bean
    @Lazy
    public HeavySecurityScanner heavySecurityScanner() {
        return new HeavySecurityScanner();
    }

    @Bean
    public static CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
