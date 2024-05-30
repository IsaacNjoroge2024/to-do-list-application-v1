package com.test.todolist.category.controller;

import com.test.todolist.category.entity.Category;
import com.test.todolist.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/tasks")
public class CategoryController {

    private final CategoryService categoryService;



    @PostMapping(value = "/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category){

        return categoryService.createCategory(category);
    }

    @GetMapping(value = "/categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Category>> findAllCategories(
            @PageableDefault() final Pageable pageable
    ){
        return (ResponseEntity.ok(categoryService.findAllCategories(pageable)));
    }

    @PutMapping(value = "/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category){

        return categoryService.updateCategory(category, categoryId);
    }

    @DeleteMapping(value = "/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId){

        categoryService.deleteCategoryById(categoryId);
    }

}
