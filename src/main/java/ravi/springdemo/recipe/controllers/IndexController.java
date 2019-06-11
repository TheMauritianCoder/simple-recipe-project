package ravi.springdemo.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javassist.NotFoundException;
import ravi.springdemo.recipe.model.Recipe;
import ravi.springdemo.recipe.services.RecipeService;

@Controller
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getView(Model model) {
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

	@RequestMapping("/recipe/{id}")
	public String viewRecipe(@PathVariable Long id, Model model) {
		Recipe recipe = null;
		try {
			recipe = recipeService.getRecipe(id);
		} catch (NotFoundException e) {
			recipe = null;
		}
		model.addAttribute("recipe", recipe);
		return "recipe";
	}

}
