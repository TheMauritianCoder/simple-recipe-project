package ravi.springdemo.recipe.model;

import javax.persistence.Entity;

@Entity
public class UnitOfMeasure extends BaseEntity{

	private String description;

	public UnitOfMeasure() {}
	
	public UnitOfMeasure(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
