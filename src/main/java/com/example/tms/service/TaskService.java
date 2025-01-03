package com.example.tms.service;


import com.example.tms.model.Task;
import com.example.tms.repository.TaskRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class TaskService {
    @Inject
    private TaskRepository repository;

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getTasks() {
        return repository.getAllTasks();
    }

    public Task getTaskById(int id) {
        return repository.findById(id);
    }

    public String delete(int id) {
        repository.delete(id);
        return "Task removed !! " + id;
    }

    public Task update(Task task) {
        return repository.update(task);
    }
}
