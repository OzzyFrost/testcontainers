package com.example.testcontainer;

import org.springframework.boot.SpringApplication;

public class TestContainerApplication {

	public static void main(String[] args) {
		SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
