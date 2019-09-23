package com.example.snssqs.controller;

import com.example.snssqs.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsController {
    @Autowired
    SnsService snsService;
    /**
     * sns发布消息接口
     */
    @GetMapping("/publish")
    public void snsPub() {
        snsService.pulishMsg();
    }
}
