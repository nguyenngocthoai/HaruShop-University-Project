package com.haru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haru.entities.Category;
import com.haru.entities.Product;
import com.haru.services.CategoryService;
import com.haru.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	

	@GetMapping("/{categoryId}/{categoryName}")
	public String productDefault(ModelMap modelMap, @PathVariable int categoryId, @PathVariable String categoryName) {
		List<Category> categories = categoryService.getCategories();
		modelMap.addAttribute("categories", categories);

		List<Product> products = productService.getProductsByCategoryId(categoryId);
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("categoryName", categoryName);

		return "product";
	}
}
