package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "Hello, World!";
    }

    @DeleteMapping("/hello")
    public String helloDelete() {
        return "Hello, World!";
    }
}
