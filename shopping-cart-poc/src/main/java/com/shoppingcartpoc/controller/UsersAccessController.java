package com.shoppingcartpoc.controller;

import java.util.Set;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcartpoc.dao.CartDAO;
import com.shoppingcartpoc.dao.OrderDAO;
import com.shoppingcartpoc.model.Cart;
import com.shoppingcartpoc.model.Product;
import com.shoppingcartpoc.model.User;
import com.shoppingcartpoc.service.CartService;
import com.shoppingcartpoc.service.OrderService;
import com.shoppingcartpoc.service.ProductService;
import com.shoppingcartpoc.service.UserService;
//paths where users can use it
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/usersAccess")
public class UsersAccessController {
	private UserService userService;
	private OrderService ordService;
	private ProductService prodService;
	private CartService cartService;
	
	public UsersAccessController(UserService userService, OrderService ordService, ProductService prodService,CartService cartService) {
		this.userService = userService;
		this.ordService = ordService;
		this.prodService = prodService;
		this.cartService=cartService;
	}
	//cart controllers
	@PostMapping("addcart/{userid}/{prodid}")
	public Cart addToCart(@PathVariable Long userid,@PathVariable Long prodid,@RequestBody CartDAO cart) {
		return cartService.addCartByUserIdAndProductId(userid, prodid, cart);
	}
	@GetMapping("cartitems/{userid}/list")
	public Set<Cart> getCart(@PathVariable Long userid){
		return cartService.getCartByUserId(userid);
	}
	//update user
	@PutMapping("/updateUser/{id}")
	public User updateTheUser(@PathVariable Long id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	//placing order
	@PostMapping("/{cartid}/placeorder")
	public void placeOrder(@PathVariable Long cartid,@RequestBody OrderDAO order) {
		 ordService.placeOrderFromCart(cartid, order);
	}
	
	//getting all products
	@GetMapping("/products/all")
	public Iterable<Product> getAllProducts(){
		return prodService.getProducts();
	}
	//getting products by id
	@GetMapping("/product/{id}")
	public Product getProductFromId(@PathVariable Long id) {
		return prodService.getProductById(id);
	}
}
