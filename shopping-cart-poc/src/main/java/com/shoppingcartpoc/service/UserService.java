package com.shoppingcartpoc.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingcartpoc.dao.UserDetailsDAO;
import com.shoppingcartpoc.exception.UserNotFoundException;
import com.shoppingcartpoc.model.User;
import com.shoppingcartpoc.repository.UserRepository;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UserService(UserRepository repository) { 
	    this.repository = repository;
	}
	public List<User> getUsers() {
	    return repository.findAll();
	}
	public User getUserById(Long id) {
	    return repository.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	    return repository.save(user);
	}
	public User updateUser(Long id,User user) {
	    User userToUpdate = repository.findById(id).orElseThrow(UserNotFoundException::new);
	 
	    userToUpdate.setFirstName(user.getFirstName());
	    userToUpdate.setEmail(user.getEmail());
	    userToUpdate.setYear(user.getYear());
	    userToUpdate.setPassword(user.getPassword());
	    return repository.save(userToUpdate);
	}
	public void deleteUser(Long id) {
	    repository.findById(id).orElseThrow(UserNotFoundException::new);
	    repository.deleteById(id);
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		
		User user=this.repository.findByEmail(email);
		return new UserDetailsDAO(user);
	}
	
	
}
