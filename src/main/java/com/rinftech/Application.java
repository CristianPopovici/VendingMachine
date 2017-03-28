package com.rinftech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication(scanBasePackages = {"com.rinftech.controller", "com.rinftech.repository", "com.rinftech.service",
        "com.rinftech.strategy"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
