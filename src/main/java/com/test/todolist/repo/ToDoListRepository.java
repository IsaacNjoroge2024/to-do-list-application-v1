package com.test.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.todolist.entity.Task;
import org.springframework.stereotype.Repository;

//gives our classes access to more functions that can be used
@Repository
public interface ToDoListRepository extends JpaRepository<Task, Long> {
    //Page<Task> findAllBy(Pageable pageable);
}
