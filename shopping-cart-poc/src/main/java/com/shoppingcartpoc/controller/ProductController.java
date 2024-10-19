package com.shoppingcartpoc.controller;



import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartpoc.model.Product;
import com.shoppingcartpoc.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/product")
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service=service;
	}
	@GetMapping("/all")
	public Iterable<Product> getAllProducts(){
		return service.getProducts();
	}
	@GetMapping("/{id}")
	public Product getProductFromId(@PathVariable Long id) {
		return service.getProductById(id);
	}
	@PostMapping("/create")
	public Product addTheProduct(@RequestBody Product product) {
		return service.addProducts(product);
	}
	@PutMapping("/update/{id}")
	public Product updateTheProduct(@PathVariable Long id,@RequestBody Product product) {
		return service.updateProduct(id, product);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTheProduct(@PathVariable Long id) {
		service.getProductById(id);
		service.deleteProduct(id);
	}
	
	  
}
