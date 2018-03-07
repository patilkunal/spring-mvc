package com.inovisionsoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inovisionsoftware.dao.CategoryDAO;
import com.inovisionsoftware.exception.EntityNotFoundException;
import com.inovisionsoftware.model.Category;

@Controller
@RequestMapping("/category")
public class CategoriesController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	// test using curl -H "Accept: application/json" http://localhost:8080/spring-mvc/category
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Category> getCategories() {		
		return categoryDAO.getCategories();
	}
	
	//test using $ curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d '{"name": "Category2"}' 'http://localhost:8080/spring-mvc/category'
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category cat) {
		return categoryDAO.saveCategory(cat);
	}

	//test using curl -H "Accept: application/json" http://localhost:8080/spring-mvc/category/1
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public @ResponseBody Category getCategory(@PathVariable("id") int id) throws EntityNotFoundException {
		Category cat = categoryDAO.getCategory(id);
		if(cat == null) { 
			throw new EntityNotFoundException("Requested category is not found");
		}
		return cat;
	}
}
