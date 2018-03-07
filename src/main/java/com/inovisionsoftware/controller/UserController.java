package com.inovisionsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inovisionsoftware.dao.UserDAO;
import com.inovisionsoftware.exception.EntityNotFoundException;
import com.inovisionsoftware.model.Address;
import com.inovisionsoftware.model.Cart;
import com.inovisionsoftware.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int id) throws EntityNotFoundException {
		User user = userDAO.getUser(id);
		if(user == null) throw new EntityNotFoundException("User not found");
		return user;
	}
	
	/*
	 * Test using following curl command
	 * curl -H "Content-Type: application/json" -d '{"firstName": "John", "lastName":"Smith", "email": "john@nowhere.com", "contactNumber": "123-123-1233", "role":"USER", "password": "123", "enabled": true}' 'http://localhost:8080/spring-mvc/user'
	 */
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user) {
		return userDAO.addUser(user);
	}
	
	@RequestMapping(value="/address/{addrid}", method=RequestMethod.GET)
	public @ResponseBody Address getAddress(@PathVariable("addrid") int id) throws EntityNotFoundException {
		Address addr = userDAO.getAddress(id);
		if(addr == null) throw new EntityNotFoundException("Address not found");
		return addr;		
	}
	
	@RequestMapping(value="/address", method=RequestMethod.POST)
	public @ResponseBody Address addAddress(@RequestBody Address addr) {
		return userDAO.addAddress(addr);
	}
	
	@RequestMapping(value="/cart/{cartid}", method=RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable("cartid") int id) throws EntityNotFoundException {
		Cart cart = userDAO.getCart(id);
		if(cart == null) throw new EntityNotFoundException("Cart not found");
		return cart;				
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.POST)
	public @ResponseBody Cart addCart(@RequestBody Cart cart) {
		return userDAO.addCart(cart);
	}
	
}
