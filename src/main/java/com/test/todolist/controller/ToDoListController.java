package com.test.todolist.controller;

import com.test.todolist.service.ToDoListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.test.todolist.entity.Task;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/tasks")
public class ToDoListController {


    private final ToDoListService toDoListService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Task> findAll(){ //(@PathVariable int offset,@PathVariable int pageSize){
        //Page<Task> taskPage = toDoListService.getAllItems(offset, pageSize);
        return toDoListService.getAllItems();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task findById(@PathVariable Long id){
       return toDoListService.getTaskById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return toDoListService.addTask(task);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Task update(@RequestBody Task task) {
        return toDoListService.updateTask(task);

    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        toDoListService.deleteTaskById(id);
    }

}
