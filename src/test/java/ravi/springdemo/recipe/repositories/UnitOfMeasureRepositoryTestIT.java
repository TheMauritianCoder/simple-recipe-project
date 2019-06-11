package ravi.springdemo.recipe.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ravi.springdemo.recipe.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setup() throws Exception{
		
	}
	
	@Test
	public void findByDescription() {
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Pinch");
		assertEquals("Pinch", uom.get().getDescription());
	}

}
