package com.example.demo.repository;

import com.example.demo.dto.TodoListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<TodoListDto, Long> {

}
