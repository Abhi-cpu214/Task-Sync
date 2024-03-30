package com.example.demo.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "todos")
public class TodoListDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<TaskDto> tasks;
}
