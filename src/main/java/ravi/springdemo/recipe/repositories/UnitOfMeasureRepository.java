package ravi.springdemo.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ravi.springdemo.recipe.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

	Optional<UnitOfMeasure> findByDescription(String description);
	
}
