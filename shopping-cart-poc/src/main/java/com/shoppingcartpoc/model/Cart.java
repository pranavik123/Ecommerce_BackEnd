package com.shoppingcartpoc.model;

import java.io.Serializable;



import javax.persistence.*;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
@EnableJpaRepositories
@Entity

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8241684809174680190L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="product_id",nullable=false)
	private Product product;
	
	@Column(name="cart_quan")
	private int quantity;
	@Column(name="cart_status")
	private int status;
	@Column(name="total_price")
	private int totalprice;
	public Cart() {
		super();
	}
	
	


	public Cart(Long id, int quantity, int status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.status = status;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}






	public User getUser() {
		return user;
	}




	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}




	public void setUser(User user) {
		this.user=user;
		
	}




	public int getTotalprice() {
		return this.totalprice;
	}




	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	


	
	
	
	
}
