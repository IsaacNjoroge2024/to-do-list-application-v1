package com.test.todolist.controller;

import com.test.todolist.task.entity.Task;
import com.test.todolist.service.ToDoListServiceBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;


import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

class TaskControllerIT extends ToDoListServiceBase {

    private RequestSpecification requestSpecification;

    @BeforeEach
    void setUp() {
        requestSpecification = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .basePath("/api/v1/tasks");
    }

    // Add findAll Test
    @Test
    @DisplayName("All tasks gotten successfully.")
    void getAllTasks() {

        Task task = createTask();
        List<Task> taskList = Collections.singletonList(task);

        int pageNumber = 1;
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Task> tasks = new PageImpl<>(taskList, pageable, taskList.size());

        requestSpecification
                .body(tasks)
                .log().all()
                .when()
                .then().log().all()
                .statusCode(HttpStatus.OK.value())
                .body("description", equalTo(task.getDescription()))
                .body("complete", equalTo(task.isComplete()));
    }
    // Add findById Test
    @Test
    @DisplayName("Task found successfully.")
    void findTaskById() {

        Task task = createTask();

        requestSpecification
                .pathParam("id", task.getTaskId())
                .body(task).log().all()
                .when()
                .get("/{id}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value())
                .body("description", equalTo(task.getDescription()))
                .body("complete", equalTo(task.isComplete()));
    }

    @Test
    @DisplayName("Verify that task is added successfully.")
    void addTask() {
        Task task = new Task()
                .setDescription("Code Java")
                .setComplete(false);

        requestSpecification
                .body(task).log().all()
                .when()
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("description", equalTo(task.getDescription()))
                .body("complete", equalTo(task.isComplete()));
    }

    // Add Update Test
   /* @Test
    @DisplayName("Task has been updated successfully.")
    void updateTask() {

        createTask();

        Task updatedTask  = createTask()
                .setDescription("Write a poem")
                .setComplete(true);

        requestSpecification
                .pathParam("id", updatedTask.getTaskId())
                .body(updatedTask).log().all()
                .when()
                .put("/{id}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value())
                .body("description", equalTo(updatedTask.getDescription()))
                .body("complete", equalTo(updatedTask.isComplete()));
    }*/

    @Test
    @DisplayName("Verify that Task is deleted successfully.")
    void deleteTask() {
        Task task = createTask();

        requestSpecification
                .pathParam("taskId", task.getTaskId())
                .when()
                .delete("/{taskId}")
                .statusCode();
    }
}
