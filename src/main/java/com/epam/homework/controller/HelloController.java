package com.epam.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from server!";
    }

    @GetMapping
    public String main() {
        return "Main hello!";
    }
}
