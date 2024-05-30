package com.test.todolist.category.repository;

import com.test.todolist.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long>{

}
