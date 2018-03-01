package com.inovisionsoftware.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inovisionsoftware.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//Transactional is needed, otherwise we get  "Could not obtain transaction-synchronized Session for current thread"
	//typically we set transactional on the service part
	@Transactional
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, id);
	}

	@Transactional
	public List<Category> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
		criteria.from(Category.class);
		return session.createQuery(criteria).getResultList();
	}

	@Transactional
	public Category saveCategory(Category cat) {
		sessionFactory.getCurrentSession().persist(cat);
		return cat;
	}

}
