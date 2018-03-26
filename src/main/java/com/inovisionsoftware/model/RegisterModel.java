package com.inovisionsoftware.model;

import java.io.Serializable;

public class RegisterModel implements Serializable {

	private static final long serialVersionUID = 8053011742566175153L;
	private User user;
	private Address billing;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	
}
