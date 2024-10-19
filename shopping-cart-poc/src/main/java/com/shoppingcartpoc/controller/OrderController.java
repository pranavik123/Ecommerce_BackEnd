package com.shoppingcartpoc.controller;


import org.springframework.web.bind.annotation.*;

import com.shoppingcartpoc.dao.OrderDAO;
import com.shoppingcartpoc.service.OrderService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {
	private OrderService service;
	public OrderController(OrderService service) {
		this.service=service;
	}

	@PostMapping("/{cartid}/placeorder")
	public void placeOrder(@PathVariable Long cartid,@RequestBody OrderDAO order) {
		 service.placeOrderFromCart(cartid, order);
		 
		
		
	}

	
	
}
