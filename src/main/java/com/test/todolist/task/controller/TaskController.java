package com.test.todolist.task.controller;

import com.test.todolist.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.test.todolist.task.entity.Task;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/tasks")
public class TaskController {


    private final TaskService taskService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Task>> findAll(
            @PageableDefault() final Pageable pageable){

        return ResponseEntity.ok(taskService.getAllItems(pageable));

    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task findById(@PathVariable Long id){

        return taskService.getTaskById(id);
    }

    @GetMapping(value = "/status")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkStatus(@RequestBody Task task){

        return taskService.checkTaskCompleted(task);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){

        return taskService.addTask(task);
    }

    @PutMapping(value = "/{id}")// You missed id here. Please add it
    @ResponseStatus(HttpStatus.OK)
    public Task update(@PathVariable Long id, @RequestBody Task task) {

        return taskService.updateTask(task, id);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        taskService.deleteTaskById(id);
    }

}
