package com.test.todolist;


import org.junit.jupiter.api.Test;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ToDoListControllerApplicationTests {

	/*@Autowired
	private ToDoListServiceImp toDoListServiceImp;

	@Autowired
	private ToDoListRepository toDoRepo;

	private String baseUrl = "http://localhost:8080/task";

	private static RestTemplate restTemplate;

	@BeforeAll
	public static void template(){
		RestTemplate restTemplate = new RestTemplate();
	}*/

	@Test
	void contextLoads() {
	}
	/*public void getAllItemsTest(){
		Task task = new Task();
		Task response = restTemplate.postForObject(baseUrl + "/task", task, Task.class);
		assert equals(response.getDescription());
	}

	public void getAllItemsTest(){
		when (toDoRepo.findAll()).thenReturn(toDoListServiceImp.getAllItems());
	}

	public void addItemTest(){

	}*/
}
