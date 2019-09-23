package com.example.snssqs.controller;

import com.example.snssqs.service.SqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sqs的消费接口
 */

@RestController
public class SqsController {
    @Autowired
    SqsService sqsService;

    @GetMapping("/consume")
    public void sqsConsume() {
        sqsService.consumeMsg();
    }
}
