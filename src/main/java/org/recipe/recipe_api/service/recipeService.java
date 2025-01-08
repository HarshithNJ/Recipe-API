package org.recipe.recipe_api.service;

import java.util.HashMap;
import java.util.Map;

import org.recipe.recipe_api.dto.recipe;
import org.recipe.recipe_api.repository.recipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class recipeService {
    
    @Autowired
    recipeRepository repository;

    public ResponseEntity<Object> saveRecipe(recipe recipe) {
        if(repository.existByName(recipe.getName())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Recipe name Alredy Exist");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else{
            repository.save(recipe);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully created");
            map.put("Data", recipe);
            
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
}
