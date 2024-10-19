package com.shoppingcartpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcartpoc.exception.UserNotFoundException;
import com.shoppingcartpoc.model.Cart;
import com.shoppingcartpoc.model.Order;
import com.shoppingcartpoc.model.OrderDetails;
import com.shoppingcartpoc.repository.CartRepository;
import com.shoppingcartpoc.repository.OrderDetailsRepository;
import com.shoppingcartpoc.repository.OrderRepository;

@Service
public class OrderDetailService {
	@Autowired
	public OrderDetailsRepository orderDRepo;
	@Autowired
	public CartRepository cartRepo;
	@Autowired
	public OrderRepository ordRepo;
	public OrderDetailService(OrderDetailsRepository orderDRepo) {
		this.orderDRepo = orderDRepo;
	}
	public OrderDetails placeTheOrder(Long cartid,Long orderid) {
		Cart cart=cartRepo.findById(cartid).orElseThrow(UserNotFoundException::new);
		Order ord=ordRepo.findById(orderid).orElseThrow(UserNotFoundException::new);
		OrderDetails order=new OrderDetails();
		order.setOrder(ord);
		order.setProduct(cart.getProduct());
		order.setTotalAmount(cart.getTotalprice());
		return orderDRepo.save(order);
		
		
	}
	public List<OrderDetails> getAllOrders(){
		return orderDRepo.findAll();
	}

}
