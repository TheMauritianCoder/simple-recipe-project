package ravi.springdemo.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ravi.springdemo.recipe.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String description);
	
}
