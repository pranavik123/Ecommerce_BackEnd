package com.shoppingcartpoc.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="order_table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String address;
	
	private LocalDate orderDate;
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	
	public Order() {
		super();
	}

	public Order(Long id, String address, LocalDate orderDate) {
		super();
		this.id = id;
		this.address = address;
		this.orderDate = orderDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
