package com.shoppingcartpoc.model;

import javax.persistence.*;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@Entity
@Table(name="order_details")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderdetailsId; 
	@ManyToOne(optional=false)
	@JoinColumn(name="order_id",nullable=false)
	private Order order;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="product_id",nullable=false)
	private Product product;
	
	private int totalAmount;
	public OrderDetails() {
		super();
		
	}
	public OrderDetails(Order order, Product product, int totalAmount) {
		super();
		this.order = order;
		this.product = product;
		this.totalAmount=totalAmount;
	}

	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getOrderdetailsId() {
		return orderdetailsId;
	}
	public void setOrderdetailsId(Long orderdetailsId) {
		this.orderdetailsId = orderdetailsId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
	
	
	
	
}
