package com.test.todolist.service;

import com.test.todolist.ApiIntegrationBaseTest;
import com.test.todolist.entity.Task;
import com.test.todolist.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ToDoListServiceBase extends ApiIntegrationBaseTest {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public Task createTask() {
        Task task = new Task()
                .setDescription("Test")
                .setComplete(true);

        return toDoListRepository.save(task);
    }
}

