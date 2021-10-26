package com.etz.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping
    public String hello(){
        return "Hello, World";
    }
}
