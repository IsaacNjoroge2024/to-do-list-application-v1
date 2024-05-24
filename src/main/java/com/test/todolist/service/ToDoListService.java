package com.test.todolist.service;

import com.test.todolist.entity.Task;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ToDoListService {

    Page<Task> getAllItems();

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);

    boolean checkTaskCompleted(Task task);
}
