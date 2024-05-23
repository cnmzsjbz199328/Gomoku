package com.tang0488;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.tang0488")
public class GomokuApplication {

    public static void main(String[] args) {
        SpringApplication.run(GomokuApplication.class, args);
    }
}
