package com.shoppingcartpoc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcartpoc.model.Product;
public interface ProductRepository extends JpaRepository<Product,Long>{

	
	
}
