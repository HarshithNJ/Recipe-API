package org.recipe.recipe_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Recipe API", version = "1.0", description = "Rest API Documentation for Recipes", 
					contact = @Contact(name = "HARSHITH N J", email = "Harshith.dev2024@outlook.com")))
public class RecipeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApiApplication.class, args);
	}

}
