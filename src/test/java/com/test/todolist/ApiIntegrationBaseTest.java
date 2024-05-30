package com.test.todolist;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = ToDoListApplication.class)
public class ApiIntegrationBaseTest {

	@LocalServerPort
	private Integer port;

	@BeforeEach
	public void setup() {
		RestAssured.baseURI = "http://localhost:" + port;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
}
