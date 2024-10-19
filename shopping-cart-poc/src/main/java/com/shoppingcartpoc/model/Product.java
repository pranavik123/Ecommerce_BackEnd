package com.shoppingcartpoc.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.*;


@Entity
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244279955352012040L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String prodName;
	private String description;
	private int quantity;
	private int price;
	@OneToMany(mappedBy="product",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Cart> cart;
	public Product(Long id, String prodName, String description, int quantity, int price) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	public Product() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
