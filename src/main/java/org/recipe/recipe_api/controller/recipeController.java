package org.recipe.recipe_api.controller;

import org.recipe.recipe_api.dto.recipe;
import org.recipe.recipe_api.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Tag(name = "Recipe Controller", description = "Controller for Performing CRUD on Recipe")
public class recipeController {

    @Autowired
    recipeService service;

    /*To Save the record*/
    @PostMapping("/recipes")
    public ResponseEntity<Object> saveRecipe(@RequestBody recipe recipe) {
        return service.saveRecipe(recipe);
    }
    
    
}
