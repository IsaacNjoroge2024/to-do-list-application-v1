package com.test.todolist.service;

import com.test.todolist.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ToDoListService {

    Page<Task> getAllItems(Pageable Page);

    //Page<Task> getAllCompletedTasks();

    //Page<Task> getAllUncompletedTasks();

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(Long id);

    Boolean checkTaskCompleted(Task task);
}
