package com.test.todolist.service;

import com.test.todolist.entity.Task;
import com.test.todolist.repository.ToDoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ToDoListServiceImp implements ToDoListService {


    private final ToDoListRepository toDoListRepository;


    @Override
    public Page<Task> getAllItems(){ //(int offset, int pageSize) {
        //Page<Task> taskPage = toDoListRepository.findAll(PageRequest.of(offset, pageSize));
        Pageable pageable = PageRequest.of(0, 10);
        return toDoListRepository.findAll(pageable);
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
