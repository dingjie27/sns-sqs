package com.example.snssqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SnsSqsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnsSqsApplication.class, args);
        System.out.println("sns-sqs-demo starting....");
    }

}
