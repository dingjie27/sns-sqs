package com.example.snssqs.configuration;

import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfiguration {
    @Bean
    public AmazonSQSClient getSqsClient() {
        AmazonSQSClient sqsClient = (AmazonSQSClient) AmazonSQSClientBuilder.defaultClient();
        return sqsClient;
    }


}
