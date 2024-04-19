package com.riwi.ToDoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.ToDoSpring.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
