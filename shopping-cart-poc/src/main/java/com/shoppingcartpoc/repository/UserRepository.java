package com.shoppingcartpoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcartpoc.model.*;
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
	
}
