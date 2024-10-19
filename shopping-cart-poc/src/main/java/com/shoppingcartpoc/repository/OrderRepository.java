package com.shoppingcartpoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcartpoc.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
