package com.mstg.todo.controller;

import com.mstg.todo.dto.BaseResponseDto;
import com.mstg.todo.dto.ErrorDto;
import com.mstg.todo.dto.ExceptionDto;
import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.service.impl.TodoService_Impl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/")
@RequiredArgsConstructor
public class TodoController {
    private final Logger _logger = LoggerFactory.getLogger(TodoController.class);

    private final TodoService_Impl _todoService;

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

        try {
            List<TodoDto> todoList = _todoService.getAlTodos();

            _logger.info("Fetching all todos.");
            return ResponseEntity.status(200).body(todoList);
        } catch (Exception e) {
            _logger.error("An error occurred while fetching all todos. Exception: {}", e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("add")
    public ResponseEntity<BaseResponseDto> addTodo(@RequestBody TodoDto dtoObj) {
        try {
            _todoService.saveTodo(dtoObj);
            _logger.info("Todo added successfully.");
            return ResponseEntity.status(201).body(dtoObj);
        } catch (DataIntegrityViolationException e) {
            _logger.error("An error occurred while adding the todo. Exception: {}", e.getMessage());
            return ResponseEntity.status(400).body(ExceptionDto.builder().message("Todo already exists.").build());
        } catch (Exception e) {
            _logger.error("An error occurred while adding the todo. Exception: {}", e.getMessage());
            return ResponseEntity.status(500).body(ExceptionDto.builder().message(e.getMessage()).build());
        }
    }

    @PutMapping("update")
    public ResponseEntity<ErrorDto> updateTodo(@RequestBody TodoDto dtoObj) {
        boolean result = _todoService.updateTodo(dtoObj);

        if (result) {
            _logger.info("Todo updated successfully.");
            return ResponseEntity.status(200).body(ErrorDto.builder()
                    .code(200)
                    .message("Todo updated successfully.")
                    .build());
        }

        _logger.error("Todo could not be updated.");
        return ResponseEntity.status(400).body(ErrorDto.builder()
                .message("Todo could not be updated.")
                .build());
    }

    @DeleteMapping("delete")
    public ResponseEntity<ErrorDto> deleteTodo(@RequestBody TodoDto dtoObj) {
        boolean result = _todoService.deleteTodo(dtoObj);

        if (result) {
            _logger.info("Todo deleted successfully.");
            return ResponseEntity.status(200).body(ErrorDto.builder()
                    .code(200)
                    .message("Todo deleted successfully.")
                    .build());
        }

        _logger.error("Todo could not be deleted.");
        return ResponseEntity.status(400).body(ErrorDto.builder()
                .code(400)
                .message("Todo could not be deleted.")
                .build());
    }
}
