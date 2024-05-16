package com.test.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.todolist.entity.Task;
//gives our classes access to more functions that can be used
public interface ToDoRepo extends JpaRepository<Task, Long> {
}
