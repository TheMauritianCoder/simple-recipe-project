package ravi.springdemo.recipe.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient extends BaseEntity {

	private String description;

	private BigDecimal amount;

	@ManyToOne
	private Recipe recipe;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;

	public Ingredient() {
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
		super();
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
		this.uom = uom;
	}

	
	public Ingredient(String description, BigDecimal amount, Recipe recipe, UnitOfMeasure uom) {
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
		this.uom = uom;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}

}
