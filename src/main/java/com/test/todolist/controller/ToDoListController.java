package com.test.todolist.controller;

import com.test.todolist.service.ToDoListService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.test.todolist.entity.Task;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/tasks")
public class ToDoListController {


    private final ToDoListService toDoListService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Task>> findAll(
            @PageableDefault(size = 10) final Pageable pageable){
        return ResponseEntity.ok(toDoListService.getAllItems(pageable));

    }

    /*public Page<Task> findAll(Pageable pageable){ //(@PathVariable int offset,@PathVariable int pageSize){
        //Page<Task> taskPage = toDoListService.getAllItems(offset, pageSize);
        return toDoListService.getAllItems(pageable);
    }*/

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task findById(@PathVariable Long id){
       return toDoListService.getTaskById(id);
    }

    /*@GetMapping(value = "completed")
    @ResponseStatus(HttpStatus.OK)
    public Page<Task> findCompletedTasks(){
        return  toDoListService.getAllCompletedTasks();
    }

    @GetMapping(value = "uncompleted")
    @ResponseStatus(HttpStatus.OK)
    public Page<Task> findUncompletedTasks(){
        return  toDoListService.getAllUncompletedTasks();
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return toDoListService.addTask(task);
    }

    @PutMapping(value = "/{id}")// You missed id here. Please add it
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
