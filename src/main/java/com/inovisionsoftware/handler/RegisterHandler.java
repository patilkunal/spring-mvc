package com.inovisionsoftware.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.inovisionsoftware.dao.UserDAO;
import com.inovisionsoftware.model.Address;
import com.inovisionsoftware.model.Cart;
import com.inovisionsoftware.model.RegisterModel;
import com.inovisionsoftware.model.User;

@Component
public class RegisterHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(RegisterHandler.class);
	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Intializes the model to hold registration information during 
	 * flow transitions
	 * 
	 * @return RegisterModel object
	 */
	public RegisterModel init() {
		
		return new RegisterModel();
		
	}
	
	/**
	 * Flow handler to hold the user information as user exits from
	 * personal view state
	 * 
	 * @param registerModel
	 * @param billing
	 */
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	/**
	 * Flow handler to hold the billing address as user exits from
	 * billing view state
	 * 
	 * @param registerModel
	 * @param billing
	 */
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	/**
	 * Flow action state handler to save user and billing address after
	 * user confirms  
	 * 
	 * @param model
	 * @return
	 */
	public String saveAll(RegisterModel model) {
		String trans = "success";
		
		User user = model.getUser();
		if("USER".equals(user.getRole())){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userDAO.addUser(user);
		
		Address addr = model.getBilling();
		addr.setUser(user);
		addr.setBilling(true);
		
		userDAO.addAddress(addr);
		return trans;
	}
	
	public String validateUser(User user, MessageContext ctx) {
		if(! user.getPassword().equals(user.getConfirmPassword())) {
			LOGGER.warn("Passwords do not match");
			ctx.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Passwords do not match!").build());
			return "invalid";
		}
		if(userDAO.getUserByEmail(user.getEmail()) != null) {
			LOGGER.warn("Email address " + user.getEmail() + " already exists");
			ctx.addMessage(new MessageBuilder().error().source("email").defaultText("Email address already exists").build());
			return "invalid";
		}
		return "valid";
	}
}
