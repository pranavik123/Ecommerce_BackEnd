package com.shoppingcartpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcartpoc.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{
	
}
