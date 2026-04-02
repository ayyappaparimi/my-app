package com.mycompany.app;

import org.springframework.boot.SpringApplication;

public class TestMyAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(MyAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
