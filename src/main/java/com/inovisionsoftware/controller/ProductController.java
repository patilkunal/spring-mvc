package com.inovisionsoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inovisionsoftware.dao.CategoryDAO;
import com.inovisionsoftware.dao.ProductDAO;
import com.inovisionsoftware.model.Category;
import com.inovisionsoftware.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam(defaultValue="0", required=false, name="id") int productId) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product p;
		if(productId > 0) {
			p = productDAO.getProduct(productId);
		} else {
			p = new Product();
			p.setQuantity(0);
		}
		mv.addObject("product", p);
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product newproduct) {
		productDAO.saveProduct(newproduct);		
		return "redirect:/product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}
}
