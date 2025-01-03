package com.example.tms.controller;

import com.example.tms.model.Task;
import com.example.tms.service.TaskService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import java.util.List;

@Controller("/tasks")
public class TaskController {
    @Inject
    TaskService taskService;
    @Get("/hello")
    public String helloWorld(){
        return "Hello World";
    }
    @Post(value = "/",consumes = "application/json", produces = "application/json")
    public Task addTask(@Body Task task) {
        return taskService.saveTask(task);
    }

    @Get(produces = "application/json")
    public List<Task> findAllTasks() {
        return taskService.getTasks();
    }

    @Get("/{id}")
    public Task findTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @Put
    public Task updateTask(@Body Task task) {
        return taskService.update(task);
    }

}
