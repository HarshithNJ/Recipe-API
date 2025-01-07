package org.recipe.recipe_api.service;

import org.recipe.recipe_api.repository.recipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class recipeService {
    
    @Autowired
    recipeRepository repository;
}
