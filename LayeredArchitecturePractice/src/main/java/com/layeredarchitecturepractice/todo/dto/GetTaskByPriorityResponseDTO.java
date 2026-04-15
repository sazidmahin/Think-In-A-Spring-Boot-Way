package com.layeredarchitecturepractice.todo.dto;

import com.layeredarchitecturepractice.todo.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetTaskByPriorityResponseDTO {
    private String title;
    private String description;
    private Date dueDate;
    private Boolean completed;
}
