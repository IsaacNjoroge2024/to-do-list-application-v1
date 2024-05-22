package com.test.todolist.Controller;

import com.test.todolist.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.test.todolist.entity.Task;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tasks")
public class ToDoListController {

    //@Autowired
    //private ToDoListServiceImp toDoListServiceImp;


    private ToDoListService toDoListService;


    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> findAll(){
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
