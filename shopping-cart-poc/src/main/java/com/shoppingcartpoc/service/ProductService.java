package com.shoppingcartpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcartpoc.exception.ProductNotFoundException;
import com.shoppingcartpoc.model.Product;
import com.shoppingcartpoc.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository=repository;
	}
	
	public Iterable<Product> getProducts(){
		return repository.findAll();
	}
	public Product getProductById( long id) {
		return repository.findById(id).orElseThrow(ProductNotFoundException::new);
	}
	public Product addProducts(Product product) {
		return repository.save(product);
	}
	public Product updateProduct(Long id,Product product) {
		Product prodToUpdate=repository.findById(id).orElseThrow(ProductNotFoundException::new);
		prodToUpdate.setProdName(product.getProdName());
		prodToUpdate.setDescription(product.getDescription());
		prodToUpdate.setPrice(product.getPrice());
		prodToUpdate.setQuantity(product.getQuantity());
		
		return repository.save(prodToUpdate);
	}
	public void deleteProduct(Long id) {
		repository.findById(id).orElseThrow(ProductNotFoundException::new);
		repository.deleteById(id);
	}
}
