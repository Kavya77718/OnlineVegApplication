package com.cg.vegetable.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vegetable {
	@Id
	private int vegId;
	private String name;
	private String type;
	private String category;
	private double price;
	private int quantity;

	@OneToMany(mappedBy= "vegetable")
	@JsonIgnore
	private List<Feedback> feedback;
	
	public Vegetable() {
	}

	public Vegetable(int vegId, String name, String type, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	public Vegetable(int vegId, String name, String type, String category, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getVegId() {
		return vegId;
	}

	public void setVegId(int vegId) {
		this.vegId = vegId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Vegetable [vegId=" + vegId + ", name=" + name + ", type=" + type + ", category=" + category + ", price="
				+ price + ", quantity=" + quantity + ", feedback=" + feedback + "]";
	}
	

}
