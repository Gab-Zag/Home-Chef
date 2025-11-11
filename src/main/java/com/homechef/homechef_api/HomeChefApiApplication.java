package com.homechef.homechef_api;

import com.homechef.homechef_api.controller.RecipeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeChefApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeChefApiApplication.class, args);
		System.out.println("Home Chef API is LAU!");
	}
}
