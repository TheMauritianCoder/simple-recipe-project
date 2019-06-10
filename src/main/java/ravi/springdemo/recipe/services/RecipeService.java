package ravi.springdemo.recipe.services;

import java.util.Set;

import ravi.springdemo.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
}
