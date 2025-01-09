package org.recipe.recipe_api.controller;

import org.recipe.recipe_api.dto.recipe;
import org.recipe.recipe_api.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Tag(name = "Recipe Controller", description = "Controller for Performing CRUD on Recipe")
public class recipeController {

    @Autowired
    recipeService service;

    /*To Save the record*/
    @Operation(summary = "To Save the record", description = "To Save the record")
    @ApiResponse(responseCode = "201", description = "Record successfully created")
    @ApiResponse(responseCode = "406", description = "Recipe name Alredy Exist")
    @PostMapping("/recipes")
    public ResponseEntity<Object> saveRecipe(@RequestBody recipe recipe) {
        return service.saveRecipe(recipe);
    }
    
    
}
