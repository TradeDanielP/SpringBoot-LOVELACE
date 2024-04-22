package com.riwi.ToDoSpring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.ToDoSpring.entity.Task;
import com.riwi.ToDoSpring.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository objTaskRepository;

    public List<Task> findAll(){
        return this.objTaskRepository.findAll();
    }

    public Page<Task> findAllPaginate(int page, int size){
        if (page < 0) {
            page = 0;}

        Pageable objPage = PageRequest.of(page, size);
        return this.objTaskRepository.findAll(objPage);
    }

    public Task create(Task objTask){
        return this.objTaskRepository.save(objTask);
    }

    public void delete(Long id){
        this.objTaskRepository.deleteById(id);
    }

    public Task findTaskById(Long id){
        return this.objTaskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task task){

        Task objTaskDB = this.findTaskById(id);
        if (objTaskDB == null) return null;
        objTaskDB = task;

        return this.objTaskRepository.save(objTaskDB);

    }
    
}
