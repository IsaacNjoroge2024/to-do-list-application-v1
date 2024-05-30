package com.test.todolist.service;

import com.test.todolist.ApiIntegrationBaseTest;
import com.test.todolist.task.entity.Task;
import com.test.todolist.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ToDoListServiceBase extends ApiIntegrationBaseTest {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask() {
        Task task = new Task()
                .setDescription("Test")
                .setComplete(true);

        return taskRepository.save(task);
    }
}

