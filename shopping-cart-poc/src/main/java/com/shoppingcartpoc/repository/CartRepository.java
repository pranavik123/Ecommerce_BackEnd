package com.shoppingcartpoc.repository;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcartpoc.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
	Set<Cart> findByUserId(Long userId);
}
