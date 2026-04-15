package com.layeredarchitecturepractice.todo.dto;

import com.layeredarchitecturepractice.todo.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetTaskResponseDTO {
    private Long taskId;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Boolean completed;
}
