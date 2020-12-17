package com.perrychambers.rms;

import com.perrychambers.rms.Order.OrderMicroservice;
import com.perrychambers.rms.Recipe.RecipeMicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@CrossOrigin(origins = "*")
@RequestMapping("/rms")
@RestController
public class RmsApplication {
    RecipeMicroservice rms = new RecipeMicroservice();
    OrderMicroservice oms = new OrderMicroservice();

    public static void main(String[] args) {
        SpringApplication.run(RmsApplication.class, args);
    }
    // Any interaction between microservices occurs here

}


