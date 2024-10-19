package com.shoppingcartpoc.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcartpoc.dao.CartDAO;
import com.shoppingcartpoc.model.*;
import com.shoppingcartpoc.repository.CartRepository;
import com.shoppingcartpoc.repository.ProductRepository;
import com.shoppingcartpoc.repository.UserRepository;

@Service

public class CartService {
	@Autowired
	private CartRepository repo;
	@Autowired
	private ProductRepository prodRepo;
	@Autowired 
	private UserRepository userRepo;
	public CartService(CartRepository repo) {
		this.repo=repo;
	}
	//add to cart
	public Cart addCartByUserIdAndProductId(Long userid,Long prodid,CartDAO cart) {
		User user=userRepo.findById(userid).orElseThrow();
		Product prod=prodRepo.findById(prodid).orElseThrow();
		Cart cart1=new Cart();
		cart1.setUser(user);
		cart1.setProduct(prod);
		cart1.setQuantity(cart.getQuantity());
		cart1.setStatus(1);
		cart1.setTotalprice(prod.getPrice()*cart1.getQuantity());
		return repo.save(cart1);
	}
	//list cart
	 public Set<Cart> getCartByUserId(Long id){
		 return repo.findByUserId(id);
	 }
	 //removeFromcart
	 public void removeProduct(Long cartid) {
		 repo.findById(cartid);
		 repo.deleteById(cartid);
	 }
}
