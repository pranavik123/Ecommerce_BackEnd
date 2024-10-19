package com.shoppingcartpoc.service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcartpoc.dao.OrderDAO;
import com.shoppingcartpoc.exception.*;
import com.shoppingcartpoc.model.*;
import com.shoppingcartpoc.repository.*;

@Service
public class OrderService {
	@Autowired
	public OrderRepository orderRepo;
	@Autowired
	public CartRepository cartRepo;
	@Autowired
	public OrderDetailsRepository ordDRepo;
	@Autowired
	public OrderDetailService ordService;
	@Autowired
	public CartService cartService;
	public OrderService(OrderRepository orderRepo) {
		this.orderRepo=orderRepo;
	}
	//place the order from cart
	public void placeOrderFromCart(Long cartid,OrderDAO orderDao) {
		Cart cart=cartRepo.findById(cartid).orElseThrow(UserNotFoundException::new);
		Order order=new Order();
		order.setUser(cart.getUser());
		order.setAddress(orderDao.getAddress());
		order.setOrderDate(LocalDate.now());
		cart.setStatus(0);
		orderRepo.save(order);
		ordService.placeTheOrder(cartid, order.getId());
		cartService.removeProduct(cartid);
		
	}

	
	
	
	
}
