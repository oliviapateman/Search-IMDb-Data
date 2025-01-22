package com.example.IMDbExercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ControllerTests {

	@Autowired
	private HomeController homeController;

	@Autowired
	private MoviesController moviesController;

	@Test
	void homePageLoads() {
		assertNotNull(homeController);
	}

	@Test
	void searchPageLoads() {
		assertNotNull(moviesController);
	}

}
