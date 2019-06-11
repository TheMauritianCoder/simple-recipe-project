package ravi.springdemo.recipe.services;

import java.util.Set;

import javassist.NotFoundException;
import ravi.springdemo.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe getRecipe(Long id) throws NotFoundException;

}
