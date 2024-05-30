package com.test.todolist.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.todolist.task.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}



