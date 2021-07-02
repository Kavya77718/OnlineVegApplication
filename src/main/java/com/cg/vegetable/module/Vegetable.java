package com.cg.vegetable.module;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VegetableEntity class
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {
	/**
	 * creating instance variables for the class VegetableEntity
	 */
	@Id
	private int vegId;
	@NotEmpty(message = "crop name should not be empty")
	private String name;
	@NotEmpty(message = "crop type should not be empty")
	private String type;
	private double price;
	private int quantity;
	private String description;
}

	