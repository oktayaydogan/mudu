package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/message/{message}")
    public String getMyMessage(@PathVariable String message) {
        return "Your message is: " + message;
    }

    @GetMapping("/variable_message/{m}")
    public String getMyVariableMessage(@PathVariable("m") String message) {
        return "Your message is: " + message;
    }

    @GetMapping("/param_message")
    public String getMyParamMessage(@RequestParam String message) {
        return "Your message is: " + message;
    }

    @GetMapping("/param_variable_message")
    public String getMyParamVariableMessage(@RequestParam("m") String message) {
        return "Your message is: " + message;
    }

    @GetMapping("/param_required_message")
    public String getMyParamRequiredMessage(@RequestParam(required = true, defaultValue = "") String message) {
        return "Your message is: " + message;
    }
}
