package com.sparta.restocknotificationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestockNotificationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestockNotificationSystemApplication.class, args);
    }

}
