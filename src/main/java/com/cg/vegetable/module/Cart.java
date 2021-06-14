package com.cg.vegetable.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * CartEntity class
 *
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	/**
	 * creating instance variables for the class CartEntity
	 */
	@Id
	@GeneratedValue
	private int cartId;
	@NonNull
	private int quantity;
	@NonNull
	private double totalAmount;
	
	/**
	 * CustomerEntity is mapped to CartEntity
	 * 
	 */
	/*@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private Customer customer;
	*/
	/**
	 * CartEntity is mapped to VegetableEntity
	 */

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "veg_Id", referencedColumnName = "vegId")
	private List<Vegetable> vegetables = new ArrayList<>();


}
