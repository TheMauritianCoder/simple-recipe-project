package ravi.springdemo.recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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

	@Test
	public void testMockMvc() throws Exception{
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("index"));
	}
	
}
