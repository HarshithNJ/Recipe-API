package org.recipe.recipe_api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;




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

    @Operation(summary = "To Save the record", description = "To Save the record")
    @ApiResponse(responseCode = "201", description = "Record successfully created")
    @ApiResponse(responseCode = "406", description = "Recipe name Alredy Exist")
    @PostMapping("/recipes/multiple")
    public ResponseEntity<Object> saveMultipleRecipes(@RequestBody List<recipe> recipes){
        return service.saveMultipleRecipes(recipes);
    }





    /* To fetch recipe the records*/
    @Operation(summary = "To fetch recipe the records", description = "To fetch all recipe the records")
    @ApiResponse(responseCode = "302", description = "Record successfully Fetched")
    @ApiResponse(responseCode = "404", description = "No records found")
    @GetMapping("/recipes")
    public ResponseEntity<Object> getAllRecipes() {
        return service.getAllRecipes();
    }
    
    @Operation(summary = "To fetch recipe the records", description = "To fetch all recipe the records")
    @ApiResponse(responseCode = "302", description = "Record successfully Fetched")
    @ApiResponse(responseCode = "404", description = "No records found")
    @GetMapping("/recipes/{name}")
    public ResponseEntity<Object> getRecipeByName(@PathVariable String name){
        return service.getRecipeByName(name);
    }









    /* To Delete By Id */
    @Operation(summary = "To Delete By Id", description = "To Delete By Id")
    @ApiResponse(responseCode = "200", description = "Record successfully deleted")
    @ApiResponse(responseCode = "404", description = "No records found")
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }
    





    /* To Update the Recipe Data */
    @Operation(summary = "To Update the Recipe Data", description = "To Update the Recipe Data")
    @ApiResponse(responseCode = "200", description = "Record successfully updated")
    @ApiResponse(responseCode = "404", description = "No records found")
    @PatchMapping("/recipes/{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable int id, @RequestBody recipe recipe){
        return service.updateRecipe(id, recipe);
    }
    
}
