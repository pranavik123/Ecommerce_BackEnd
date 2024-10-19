package com.shoppingcartpoc.dao;

import com.shoppingcartpoc.model.Order;
import com.shoppingcartpoc.model.Product;
import com.shoppingcartpoc.model.User;

public class OrderDetailsDAO {
	private User user;
	private Product product;
	private Order order;
	
	public OrderDetailsDAO(User user, Product product, Order order) {
		super();
		this.user = user;
		this.product = product;
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
