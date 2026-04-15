package com.layeredarchitecturepractice.todo.service;

import com.layeredarchitecturepractice.todo.dto.CreateTaskRequestDTO;
import com.layeredarchitecturepractice.todo.dto.GetTaskByPriorityResponseDTO;
import com.layeredarchitecturepractice.todo.dto.GetTaskResponseDTO;
import com.layeredarchitecturepractice.todo.entity.Task;
import com.layeredarchitecturepractice.todo.enums.Priority;
import com.layeredarchitecturepractice.todo.enums.Status;
import com.layeredarchitecturepractice.todo.exception.TaskNotFoundException;
import com.layeredarchitecturepractice.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public String createTask(CreateTaskRequestDTO createTaskRequestDTO)
    {
        Task task=new Task();
        task.setTitle(createTaskRequestDTO.getTitle());
        task.setDescription(createTaskRequestDTO.getDescription());
        task.setDueDate(createTaskRequestDTO.getDueDate());
        task.setPriority(createTaskRequestDTO.getPriority());
        todoRepository.save(task);
        return "Task Created Successfully";
    }
    public List<GetTaskResponseDTO> getAllTask(){
        List<Task> tasks = todoRepository.findByStatus(Status.ACTIVE);

        return tasks.stream()
                .map(task -> new GetTaskResponseDTO(
                        task.getTaskId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getDueDate(),
                        task.getPriority(),
                        task.getCompleted()
                ))
                .toList();
    }
    @Transactional
    public void markTaskAsCompleted(Long taskId)
    {
        Task task = todoRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task Not Found"));
        task.setCompleted(true);
    }
    public List<GetTaskByPriorityResponseDTO>getTasksByPriority(Priority priority)
{
    List<Task> tasks=todoRepository.findTasksByPriority(priority,Status.ACTIVE);
    return tasks.stream().map(task->new GetTaskByPriorityResponseDTO(
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getCompleted()
    )).toList();
}
@Transactional
    public void deleteTaskById(Long taskId)
{
    Task task=todoRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not Found"));
    task.setStatus(Status.INACTIVE);
}
}
