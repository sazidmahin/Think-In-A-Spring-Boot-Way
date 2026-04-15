package com.layeredarchitecturepractice.todo.controller;

import com.layeredarchitecturepractice.todo.dto.CreateTaskRequestDTO;
import com.layeredarchitecturepractice.todo.dto.GetTaskByPriorityResponseDTO;
import com.layeredarchitecturepractice.todo.dto.GetTaskResponseDTO;
import com.layeredarchitecturepractice.todo.enums.Priority;
import com.layeredarchitecturepractice.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/tasks")
    public List<GetTaskResponseDTO> getAllTask()
    {
        return todoService.getAllTask();
    }
    @GetMapping("/task/{priority}")
    public List<GetTaskByPriorityResponseDTO> getTaskByPriority(@PathVariable Priority priority)
    {
        return todoService.getTasksByPriority(priority);
    }
    @PostMapping("/create-task")
    public void createTask(@RequestBody @Valid CreateTaskRequestDTO createTaskRequestDTO)
    {
        todoService.createTask(createTaskRequestDTO);
    }
    @DeleteMapping("delete-task/{taskId}")
    public void deleteTask(@PathVariable Long taskId)
    {
        todoService.deleteTaskById(taskId);
    }
}
