package org.recipe.recipe_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        if(repository.existsByName(recipe.getName())){
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

    public ResponseEntity<Object> saveMultipleRecipes(List<recipe> recipes) {
        for(recipe recipe : recipes){
            if(repository.existsByName(recipe.getName())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Recipe name Alredy Exist");
    
                return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
            }
        }
        repository.saveAll(recipes);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Record successfully created");
        map.put("Data", recipes);
        
        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }







    

    public ResponseEntity<Object> getAllRecipes() {
        List<recipe> li = repository.findAll();

        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No records found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully created");
            map.put("Data", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getRecipeByName(String name) {
        Optional<recipe> op = repository.findByName(name);

        if(op.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully fetched");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No records found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteById(int id) {
        Optional<recipe> op = repository.findById(id);

        if(op.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully deleted");
            map.put("Data", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No records found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

}
