package com.inovisionsoftware.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inovisionsoftware.dao.UserDAO;
import com.inovisionsoftware.exception.CartNotAllowedException;
import com.inovisionsoftware.exception.EntityNotFoundException;
import com.inovisionsoftware.model.Address;
import com.inovisionsoftware.model.Cart;
import com.inovisionsoftware.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);
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

	@RequestMapping(value="/{userid}/shippingaddress", method=RequestMethod.GET)
	public @ResponseBody List<Address> getShippingAddress(@PathVariable("userid") int userid) throws EntityNotFoundException {
		User user = userDAO.getUser(userid);
		if(user == null) throw new EntityNotFoundException("User not found");
		return userDAO.getShippingAddresses(user);
	}
	
	@RequestMapping(value="/{userid}/billingaddress", method=RequestMethod.GET)
	public @ResponseBody Address getBillingAddress(@PathVariable("userid") int userid) throws EntityNotFoundException {
		User user = userDAO.getUser(userid);
		if(user == null) throw new EntityNotFoundException("User not found");
		return userDAO.getBillingAddress(user);
	}	
	
	@RequestMapping(value="/{userid}/address/shipping", method=RequestMethod.POST)
	public @ResponseBody Address addShippingAddress(
			@PathVariable("userid") int userid, 
			@RequestBody Address addr) throws EntityNotFoundException {
		User user = userDAO.getUser(userid);
		if(user == null) throw new EntityNotFoundException("User not found");
		addr.setUser(user);
		addr.setShipping(true);
		return userDAO.addAddress(addr);
	}
	
	@RequestMapping(value="/{userid}/address/billing", method=RequestMethod.POST)
	public @ResponseBody Address addBillingAddress(
			@PathVariable("userid") int userid, 
			@RequestBody Address addr) throws EntityNotFoundException {
		User user = userDAO.getUser(userid);
		if(user == null) throw new EntityNotFoundException("User not found");
		addr.setUser(user);
		addr.setBilling(true);
		return userDAO.addAddress(addr);
	}
	
	@RequestMapping(value="/cart/{cartid}", method=RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable("cartid") int id) throws EntityNotFoundException {
		Cart cart = userDAO.getCart(id);
		if(cart == null) throw new EntityNotFoundException("Cart not found");
		return cart;				
	}
	
	/*
	 * $ curl -X PUT -H "Content-type: application/json" -d '{"grandTotal": 500.55, "cartLines": 10}' 'http://localhost:8080/spring-mvc/user/10/cart'
	 */
	@RequestMapping(value="/{userid}/cart", method=RequestMethod.PUT)
	public @ResponseBody Cart addCart(
			@PathVariable("userid") int userid, 
			@RequestBody Cart cart) throws EntityNotFoundException, CartNotAllowedException {
		User user = userDAO.getUser(userid);
		if(user == null) throw new EntityNotFoundException("User not found");
		if("USER".equals(user.getRole())) {
			Cart usercart = user.getCart();
			if(usercart == null) {
				usercart = new Cart();
			}
			usercart.setCartLines(cart.getCartLines());
			usercart.setGrandTotal(cart.getGrandTotal());
			LOGGER.info("Updating cart " + usercart);
			return userDAO.updateCart(usercart);
		} else {
			throw new CartNotAllowedException(user.getRole() + " is not allowed to have a cart");
		}
	}
	
}
