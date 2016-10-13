package com.fcat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcat.service.TestOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class CraftApplication {
    public static void main(String[] args) {

        SpringApplication.run(CraftApplication.class, args);

    }


    // public ObjectMapper mapper() {
    // Customize...
    //  return new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
    //      ;
}


