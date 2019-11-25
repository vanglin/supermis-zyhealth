package com.smartpro.mis.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.smartpro.mis"})
public class SupermisRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermisRestApplication.class, args);
    }
}
