package com.test.todolist.task.service;

import com.test.todolist.task.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TaskService {


    Page<Task> getAllItems(Pageable Page);

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task, Long id);

    void deleteTaskById(Long id);

    boolean checkTaskCompleted(Task task);
}
