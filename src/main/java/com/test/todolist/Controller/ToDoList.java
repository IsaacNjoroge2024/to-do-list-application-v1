package com.test.todolist.Controller;

import com.test.todolist.repo.ToDoRepo;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.test.todolist.entity.Task;

import java.util.List;
//@RestController makes the class a rest endpoint. We can interact with this class with the GET, POST, PUT, PATCH, DELETE http methods.
@RestController //simplifies the creation of this service. Combines the @ResponseBody and @Controller, so we don't have to manually input them in our code
@RequestMapping(value = "/task") //allows us to access this class in the url using /task. Maps requests to controller methods.
public class ToDoList {

    @Autowired //automatically initializes the repo. Automatically assigns a value to the todoRepo.
    private ToDoRepo todoRepo;

    @GetMapping //handles GET type requests.
    public List<Task> findAll(){ //fetches all elements in Task. Because we the user will put multiple items, we have to change the Task to a List<>
        return todoRepo.findAll(); //a function available due to the extension of the Jpa repository in the repo
    }

    //The @RequestBody maps the HTTP request body to a transfer or domain object.
    //The request body reads and deserializes into an object through the HttpMessageReader.

    @PostMapping //handles POST types requests.
    public Task save(@RequestBody Task task){
        return todoRepo.save(task);
    }

    @PutMapping //handles PUT type requests.
    public Task update(@RequestBody Task task){
        return todoRepo.save(task);
    }
    @DeleteMapping(value = "/{id}") // handles DEL type requests.
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);

    }
    //the @path annotation identifies the URL template to which the resource responds. This is specified at the class level of the resource.
    //the @pathvariable annotation is applied to a method parameter and indicates that the value specified in the parameter should be extracted/removed from the URL.


}
