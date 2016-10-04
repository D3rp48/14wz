package com.fcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class CraftApplication {

    public static void main(String[] args) {
        SpringApplication.run(CraftApplication.class, args);
    }
}
