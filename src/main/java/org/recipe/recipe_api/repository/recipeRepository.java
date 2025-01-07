package org.recipe.recipe_api.repository;

import org.recipe.recipe_api.dto.recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface recipeRepository extends JpaRepository<recipe,Integer> {

}
