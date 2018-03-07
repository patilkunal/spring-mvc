package com.inovisionsoftware.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="user_detail")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;	
	private String email;
	@Column(name="contact_number")
	private String contactNumber;
	private String role;
	private String password;
	private boolean enabled=true;

	//** BIDRECTIONAL MAPPING EXPLAINED **
	//Adding OnetoOne creates(requires) a cart_id column in the user table for bidirectional relationship
	//If we want User to own the relationship (be the parent) and remove the cart_id column from the User table, we need to add mapped by 
	//the mapped by references the property from Cart used to relate to User
	//Cascade is used to create child records (Cart) as soon as User is created (we need to set Cart object before we save user)
	//CascadeType.ALL will cascade all the operations: create, update, delete to child records
	//@code{ cart.setUser(user) and user.setCart(cart) }
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Cart cart;
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Cart getCart() {
		return cart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
