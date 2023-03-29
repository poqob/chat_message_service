package com.message_service.message_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Service {

    @GetMapping
    public String getAllMessages() {
        return "esenlikler dilerim";
    }
}
