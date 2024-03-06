package com.mstg.todo.controller;

import com.mstg.todo.dto.HelloDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo/")
public class TodoController {

    @GetMapping("hello")
    public ResponseEntity<HelloDto> hello(@RequestParam String name) {
        if (!name.isEmpty())
            /*
            return "Hello " + name + "!";
            return ResponseEntity.status(200).body("Hello " + name + "!");
            */
            return ResponseEntity.status(200).body(HelloDto.builder()
                    .message("Hello " + name + "!")
                    .build());
        //return "Name is required";
        //return ResponseEntity.status(400).body("Name is required");
        return ResponseEntity.status(400).body(HelloDto.builder()
                .message("Name is required!")
                .build());
    }

    @PostMapping("hello")
    public ResponseEntity<HelloDto> helloPost(@RequestBody HelloDto helloDto) {
        if (helloDto.getMessage() != null && !helloDto.getMessage().isEmpty())
            return ResponseEntity.status(200).body(HelloDto.builder()
                    .message("Hello " + helloDto.getMessage() + "!")
                    .build());
        return ResponseEntity.status(400).body(HelloDto.builder()
                .message("Name is required!")
                .build());
    }

    @PutMapping("hello")
    public ResponseEntity<HelloDto> helloPut(@RequestBody HelloDto helloDto) {
        if (helloDto.getMessage() != null && !helloDto.getMessage().isEmpty())
            return ResponseEntity.status(200).body(HelloDto.builder()
                    .message("Hello " + helloDto.getMessage() + "!")
                    .build());
        return ResponseEntity.status(400).body(HelloDto.builder()
                .message("Name is required!")
                .build());
    }
}
