package ravi.springdemo.recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import ravi.springdemo.recipe.model.Recipe;
import ravi.springdemo.recipe.services.RecipeServiceImpl;

public class IndexControllerTest {

	IndexController indexController;
	
	@Mock
	RecipeServiceImpl recipeService;
	
	@Mock
	Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testGetView() {
		
		//given
		Set<Recipe> recipes = new HashSet<Recipe>();
		
		Recipe recipe1= new Recipe();
		recipe1.setId(1L);
		
		Recipe recipe2= new Recipe();
		recipe2.setId(1L);
		
		recipes.add(recipe1);
		recipes.add(recipe2);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> arguementCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = indexController.getView(model);
		
		//then 
		assertEquals("index", viewName);		
		verify(recipeService,times(1)).getRecipes();
		verify(model,times(1)).addAttribute(ArgumentMatchers.eq("recipes"),arguementCaptor.capture());
		assertEquals(2, arguementCaptor.getValue().size());
	}

}
