package ravi.springdemo.recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import ravi.springdemo.recipe.model.Recipe;
import ravi.springdemo.recipe.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

	@Override
	public Recipe getRecipe(Long id) throws NotFoundException {			
		Optional<Recipe> optionalRecipe = recipeRepository.findById(id); 
		if(!optionalRecipe.isPresent()) {
			throw new NotFoundException("Recipe with ID "+id+" not found");
		}
		return optionalRecipe.get();		
	}
	
}
