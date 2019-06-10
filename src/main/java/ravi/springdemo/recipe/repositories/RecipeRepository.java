package ravi.springdemo.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import ravi.springdemo.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
