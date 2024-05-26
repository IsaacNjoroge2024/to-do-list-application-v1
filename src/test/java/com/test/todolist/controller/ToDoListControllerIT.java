package com.test.todolist.controller;

import com.test.todolist.entity.Task;
import com.test.todolist.service.ToDoListServiceBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


import static org.hamcrest.Matchers.equalTo;

class ToDoListControllerIT extends ToDoListServiceBase {
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

    // Add findById Test

    @Test
    @DisplayName("Verify that task is successfully.")
    void createSuccess() {
        Task task = new Task()
                .setDescription("Code Java")
                .setComplete(false);

        requestSpecification
                .body(task).log().all()
                .when()
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("description", equalTo(task.getDescription()))
                .body("isComplete", equalTo(task.isComplete()));
    }

    // Add Update Test

    @Test
    @DisplayName("Verify that Task is deleted successfully.")
    void deleteSuccess() {
        Task task = createTask();

        requestSpecification
                .pathParam("taskId", task.getTaskId())
                .when()
                .delete("/{taskId}")
                .statusCode();
    }
}
