package com.test.todolist.service;

import com.test.todolist.entity.Task;
import com.test.todolist.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ToDoListServiceBase {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Test
    public void SaveTask(){
        Task task = new Task()
                .setDescription("Test")
                .setComplete(true);

        toDoListRepository.save(task);
        System.out.println(task);
    }

    }

