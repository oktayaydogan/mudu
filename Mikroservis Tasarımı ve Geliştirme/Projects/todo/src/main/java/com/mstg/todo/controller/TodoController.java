package com.mstg.todo.controller;

import com.mstg.todo.dto.HelloDto;
import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.service.impl.TodoService_Impl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/")
public class TodoController {

    private final TodoService_Impl _todoService;

    public TodoController(TodoService_Impl todoService) {
        _todoService = todoService;
    }

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

    @GetMapping("all")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        /*
        List<TodoDto> todoList = new ArrayList<>();

        TodoDto todo1 = TodoDto.builder()
                .title("Masanı Topla.")
                .detail("Masanı toplamak için 5 dakikanı ayır.")
                .build();

         */
        /*
        TodoDto todo2 = new TodoDto("Çamaşırları Yıka", "Çamaşırları yıkamak için 1 saat ayır.");
        TodoDto todo3 = new TodoDto();

        todo3.setTitle("Yemek Yap");
        todo3.setDetail("Yemek yapmak için 1 saat ayır.");
        */

        // todoList.add(todo1);
        //todoList.add(todo2);
        //todoList.add(todo3);

        List<TodoDto> todoList = _todoService.getAlTodos();

        return ResponseEntity.status(200).body(todoList);
    }

    @PostMapping("add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto dtoObj) {
        boolean result = _todoService.saveTodo(dtoObj);

        if (result)
            return ResponseEntity.status(201).body(TodoDto.builder()
                    .message("Todo added successfully.")
                    .build());
        return ResponseEntity.status(599).body(new TodoDto());
    }
}
