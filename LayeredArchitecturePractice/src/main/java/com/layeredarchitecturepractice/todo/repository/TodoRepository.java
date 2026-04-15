package com.layeredarchitecturepractice.todo.repository;

import com.layeredarchitecturepractice.todo.entity.Task;
import com.layeredarchitecturepractice.todo.enums.Priority;
import com.layeredarchitecturepractice.todo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TodoRepository extends JpaRepository<Task,Long> {
    List<Task> findTasksByPriority(Priority priority, Status status);
    List<Task>findByStatus(Status status);
}
