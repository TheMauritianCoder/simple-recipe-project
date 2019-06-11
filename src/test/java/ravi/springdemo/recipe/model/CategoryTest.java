package ravi.springdemo.recipe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;
	
	@Before
	public void setup() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception{
		Long testId = 4L;
		category.setId(testId);		
		assertEquals(testId, category.getId());		
	}

	@Test
	public void getDescription() throws Exception{
		
	}
	
	@Test
	public void getRecipes() throws Exception{
		
	}
}
