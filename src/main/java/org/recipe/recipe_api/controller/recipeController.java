package org.recipe.recipe_api.controller;

import org.recipe.recipe_api.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Recipe Controller", description = "Controller for Performing CRUD on Recipe")
public class recipeController {

    @Autowired
    recipeService service;
    
}
