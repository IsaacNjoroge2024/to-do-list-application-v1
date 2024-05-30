package com.test.todolist.task.service;


import com.test.todolist.task.entity.Task;
import com.test.todolist.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskServiceImp implements TaskService {


    private final TaskRepository taskRepository;


    @Override

    public Page<Task> getAllItems(Pageable pageable){

        return taskRepository.findAll(pageable);
    }

    @Override
    public Task getTaskById(Long id) {

        return taskRepository.findById(id).get();
    }

    @Override
    public Task addTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task, Long id) {

        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {

       taskRepository.deleteById(id);
    }
    @Override
    public boolean checkTaskCompleted(Task task) {

        if(task.isComplete()){
            taskRepository.save(task);
            return task.isComplete();
        }
        return false;
    }
}
