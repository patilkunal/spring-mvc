package com.inovisionsoftware.dao;

import java.util.List;

import com.inovisionsoftware.model.Category;

public interface CategoryDAO {
	
	public Category getCategory(int id);
	public List<Category> getCategories();
	public Category saveCategory(Category cat);

}
