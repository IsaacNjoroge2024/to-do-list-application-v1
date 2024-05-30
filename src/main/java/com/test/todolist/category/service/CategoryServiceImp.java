package com.test.todolist.category.service;

import com.test.todolist.category.entity.Category;
import com.test.todolist.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category createCategory(Category category){

        return categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAllCategories(Pageable pageable){

        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category updateCategory(Category category, Long id){

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id){

        categoryRepository.deleteById(id);

    }
}
