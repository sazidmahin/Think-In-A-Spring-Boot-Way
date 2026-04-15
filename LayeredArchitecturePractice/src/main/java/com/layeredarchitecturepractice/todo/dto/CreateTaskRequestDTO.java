package com.layeredarchitecturepractice.todo.dto;

import com.layeredarchitecturepractice.todo.enums.Priority;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class CreateTaskRequestDTO {
    @NotBlank
    @Size(min=3 , max=100)
    @Column(nullable = false)
    private String title;

    @Size(max=1000)
    private String description;

    @FutureOrPresent
    private Date dueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
