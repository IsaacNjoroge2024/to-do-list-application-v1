package com.test.todolist.service;

import com.test.todolist.entity.Task;
import com.test.todolist.repo.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoListServiceTest {   //Here i have unnecessary stubbings

    @Mock
    private ToDoListRepository toDoListRepository;

    @InjectMocks
    private ToDoListServiceImp toDoListServiceImp;


    @Test
    public void ToDoListService_GetsAllItems_ReturnsItems(){

        List<Task> tasks = Mockito.mock(String.valueOf(Task.class));

        when(this.toDoListRepository.findAll()).thenReturn(tasks);

        List<Task> savedTask = toDoListServiceImp.getAllItems();

        Assertions.assertThat(savedTask).isNotNull();

    }
    @Test
    public void ToDoListService_GetItemsById_ReturnItem(){
        long taskId = 1;
        Task tasks = Mockito.mock(String.valueOf(Task.class));
        when(toDoListRepository.findById(taskId)).thenReturn(Optional.ofNullable(tasks));

        Task taskReturn = toDoListServiceImp.getTaskById(taskId);
        Assertions.assertThat(taskReturn).isNotNull();
    }

    @Test
    public void ToDoListService_AddTask_AddItem(){

        Task task = Mockito.mock(String.valueOf(Task.class));
        when(toDoListRepository.save(task)).thenReturn(task);
        Task addedTask = toDoListServiceImp.addTask(task);
        Assertions.assertThat(addedTask).isNotNull();
    }

    @Test
    public void ToDoListService_UpdateTask_UpdateItem(){
        Task updatedTask = Mockito.mock(String.valueOf(Task.class));
        Assertions.assertThat(updatedTask).isNotNull();
    }

    @Test
    public void ToDoListService_DeleteTask_DeleteItem(){
        Task deletedTask = Mockito.mock(String.valueOf(Task.class));
        Assertions.assertThat(deletedTask).isNotNull();
    }



}
