package com.test.todolist.service;

import com.test.todolist.entity.Task;
import com.test.todolist.repo.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListServiceImp implements ToDoListService {


    private ToDoListRepository toDoListRepository;


    @Override
    public List<Task> getAllItems() {
        return toDoListRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return toDoListRepository.findById(id).get();
    }

    @Override
    public Task addTask(Task task) {
        return toDoListRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return toDoListRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
       toDoListRepository.deleteById(id);
    }
    @Override
    public boolean checkTaskCompleted(Task task) {
        toDoListRepository.save(task);
        return task.isComplete();
    }
}
