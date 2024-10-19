package com.shoppingcartpoc.controller;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartpoc.dao.CartDAO;
import com.shoppingcartpoc.model.Cart;
import com.shoppingcartpoc.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService service;
	
	public CartController(CartService service) {
		this.service=service;
	}
	//add to cart
	@PostMapping("addcart/{userid}/{prodid}")
	public Cart addToCart(@PathVariable Long userid,@PathVariable Long prodid,@RequestBody CartDAO cart) {
		return service.addCartByUserIdAndProductId(userid, prodid, cart);
	}
	@GetMapping("/{userid}/list")
	public Set<Cart> getCart(@PathVariable Long userid){
		return service.getCartByUserId(userid);
	}
	@DeleteMapping("delete/{cartid}")
	public void removeFromCart(@PathVariable Long cartid) {
		service.removeProduct(cartid);
	}
	

}
