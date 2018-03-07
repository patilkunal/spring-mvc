package com.inovisionsoftware.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inovisionsoftware.model.Address;
import com.inovisionsoftware.model.Cart;
import com.inovisionsoftware.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User getUser(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public User getUserByEmail(String email) {
		String querysql = "FROM User where email = :emailAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(querysql, User.class);
		List list = query.setParameter("emailAddress", email).getResultList();
		
		return (User) (list != null && !list.isEmpty() ? list.get(0) : null);
	}
	@Override
	public User addUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		return user;
	}

	@Override
	public Address getAddress(int id) {
		return sessionFactory.getCurrentSession().get(Address.class, id);
	}
	@Override
	public Address addAddress(Address addr) {
		sessionFactory.getCurrentSession().persist(addr);
		return addr;
	}

	@Override
	public Cart getCart(int id) {
		return sessionFactory.getCurrentSession().get(Cart.class, id);
	}
	@Override
	public Cart addCart(Cart cart) {
		sessionFactory.getCurrentSession().persist(cart);
		return cart;
	}

}
