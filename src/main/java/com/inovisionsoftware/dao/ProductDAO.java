package com.inovisionsoftware.dao;

import java.util.List;

import com.inovisionsoftware.model.Product;

public interface ProductDAO {

	public void saveProduct(Product p);
	public Product getProduct(int id);
	public List<Product> getProducts();
	
}
