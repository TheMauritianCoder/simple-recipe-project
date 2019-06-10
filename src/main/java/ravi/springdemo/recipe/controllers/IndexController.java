package ravi.springdemo.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
