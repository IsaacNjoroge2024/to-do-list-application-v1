package com.test.todolist.category.service;

import com.test.todolist.category.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> findAllCategories(Pageable pageable);

    Category createCategory(Category category);

    Category updateCategory(Category category, Long id);

    void deleteCategoryById(Long id);
}
