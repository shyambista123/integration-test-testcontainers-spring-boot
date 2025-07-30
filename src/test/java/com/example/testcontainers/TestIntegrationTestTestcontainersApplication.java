package com.example.testcontainers;

import org.springframework.boot.SpringApplication;

public class TestIntegrationTestTestcontainersApplication {

    public static void main(String[] args) {
        SpringApplication.from(TestTestcontainersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
