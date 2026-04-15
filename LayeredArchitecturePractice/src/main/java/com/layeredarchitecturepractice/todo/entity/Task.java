package com.layeredarchitecturepractice.todo.entity;

import com.layeredarchitecturepractice.todo.enums.Priority;
import com.layeredarchitecturepractice.todo.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank
    @Size(min=3 , max=100)
    @Column(nullable = false)
    private String title;

    @Size(max=1000)
    private String description;

    @CreationTimestamp
    private Date createdAt;

    @FutureOrPresent
    private Date dueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull
    private Boolean Completed;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

}
