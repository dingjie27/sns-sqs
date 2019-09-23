package com.example.snssqs.controller;

import com.example.snssqs.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnsController {
    @Autowired
    SnsService snsService;

    @GetMapping("/pub")
    public void testSnsPub() {
        snsService.pulishMsg();
    }
}
