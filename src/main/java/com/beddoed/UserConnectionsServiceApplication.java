package com.beddoed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class UserConnectionsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConnectionsServiceApplication.class, args);
    }
}
