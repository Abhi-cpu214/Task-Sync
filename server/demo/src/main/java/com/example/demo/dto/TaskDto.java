package com.example.demo.dto;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String description;
    private String datetime;
}
