package com.mstg.todo.service.impl;

import com.mstg.todo.controller.TodoController;
import com.mstg.todo.dto.TodoDto;
import com.mstg.todo.model.Todo;
import com.mstg.todo.repository.TodoRepository;
import com.mstg.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService_Impl implements TodoService {
    private final Logger _logger = LoggerFactory.getLogger(TodoService_Impl.class);
    private final TodoRepository _todoRepository;

    @Override
    public List<TodoDto> getAlTodos() {
        try {
            List<Todo> todoList = _todoRepository.findAll();


            if(!todoList.isEmpty()){
                _logger.info("Fetching all todos.");

                return todoList.stream()
                        .map(todo -> TodoDto.builder()
                                .title(todo.getTitle())
                                .detail(todo.getDetail())
                                .completed(todo.isCompleted())
                                .build())
                        .collect(Collectors.toList());
                }

            _logger.info("No todos found.");
            return Collections.emptyList();
        } catch (Exception e) {
            _logger.error("An error occurred while fetching the todos. Exception: {}", e.getMessage());
            throw new RuntimeException("An error occurred while fetching the todos.");
        }
    }

    @Override
    public Todo getTodo(String title) {
        try {
            Optional<Todo> optionalTodo = _todoRepository.findByTitle(title);

            if (optionalTodo.isPresent()) {
                _logger.info("Fetching todo with title: {}", title);
                Todo todo = optionalTodo.get();

                //return TodoDto.builder()
                //        .id(todo.getId())
                //        .title(todo.getTitle())
                //        .detail(todo.getDetail())
                //        .build();

                return todo;
            }

            _logger.info("No todo found with title: {}", title);
            return null;
        } catch (Exception e) {
            _logger.error("An error occurred while fetching the todo. Exception: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public boolean saveTodo(TodoDto obj) {
        try {

            // Optional<Todo> dbTodo = _todoRepository.findByTitle(obj.getTitle());

            // if (dbTodo.isEmpty()) {
            //     _logger.info("Todo already exists with title: {}", obj.getTitle());
            //     throw new RuntimeException("Todo already exists with title: " + obj.getTitle());
            // }

            Todo newTodo = Todo.builder()
                    .title(obj.getTitle())
                    .detail(obj.getDetail())
                    .completed(false)
                    .build();

            Todo savedEntity = _todoRepository.save(newTodo);
            _logger.info("Todo saved: {}", savedEntity);
            return true;
        } catch (DataIntegrityViolationException e) {
            _logger.error("An error occurred while saving the todo. Exception: {}", e.getMessage());
            throw new DataIntegrityViolationException(e.getMessage());
            // return false;
        } catch (Exception e) {
            _logger.error("An error occurred while saving the todo. Exception: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
            // return false;
        }
    }

    @Override
    public boolean updateTodo(TodoDto obj) {
        try {
            Todo todo = getTodo(obj.getTitle());

            if (todo != null) {
                if (obj.getDetail() == null && !todo.isCompleted()) {
                    todo.setCompleted(true);

                    _logger.info("Todo completed: {}", todo);
                } else if (obj.getDetail() != null) {
                    todo.setDetail(obj.getDetail());

                    _logger.info("Todo detail changed: {}", todo);
                }

                _logger.info("Object: {}", obj.isCompleted());
                _logger.info("Todo: {}", todo.isCompleted());

                _todoRepository.save(todo);

                _logger.info("Todo updated: {}", todo);
                return true;
            }

            _logger.warn("No todo found with title: {}", obj.getTitle());
            return false;
        } catch (Exception e) {
            _logger.error("An error occurred while updating the todo. Exception: {}", e.getMessage());
            return false;
        }
    }

    public boolean deleteTodo(TodoDto obj) {
        try {
            Todo todo = getTodo(obj.getTitle());

            if (todo != null) {
                _todoRepository.delete(todo);
                _logger.info("Todo deleted: {}", todo);
                return true;
            }

            _logger.warn("No todo found with title: {}", obj.getTitle());
            return false;
        } catch (Exception e) {
            _logger.error("An error occurred while deleting the todo. Exception: {}", e.getMessage());
            return false;
        }
    }
}
