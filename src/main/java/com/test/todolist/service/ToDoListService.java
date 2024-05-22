package com.test.todolist.service;

import com.test.todolist.entity.Task;

import java.util.List;


public interface ToDoListService {

    List<Task> getAllItems();

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);

    boolean checkTaskCompleted(Task task);
}
