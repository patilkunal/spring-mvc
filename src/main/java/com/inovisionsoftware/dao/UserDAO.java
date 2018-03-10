package com.inovisionsoftware.dao;

import com.inovisionsoftware.model.Address;
import com.inovisionsoftware.model.Cart;
import com.inovisionsoftware.model.User;

public interface UserDAO {

	public User getUser(int id);
	public User getUserByEmail(String email);
	public User addUser(User user);
	public Address getAddress(int id);
	public Address addAddress(Address addr);
	public Cart getCart(int id);
	public Cart updateCart(Cart cart);
}
