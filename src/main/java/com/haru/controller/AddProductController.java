package com.haru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haru.entities.Category;
import com.haru.entities.Product;
import com.haru.entities.ProductColor;
import com.haru.entities.ProductSize;
import com.haru.services.CategoryService;
import com.haru.services.ProductColorService;
import com.haru.services.ProductService;
import com.haru.services.ProductSizeService;

@Controller
@RequestMapping("/addproduct")
public class AddProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductSizeService productSizeService;

	@Autowired
	ProductColorService productColorService;

	@GetMapping
	public String addProductDefault(ModelMap modelMap) {
		/**
		 * product hot
		 */
		List<Product> products = productService.getListProductLimit(0);
		modelMap.addAttribute("products", products);

		/**
		 * product pagination
		 */
		List<Product> allProduct = productService.getListProductLimit(-1);
		modelMap.addAttribute("allProduct", allProduct);

		double sumPage = Math.ceil((double)allProduct.size() / 5);
		modelMap.addAttribute("sumPage", sumPage);
		
		List<Category> categories = categoryService.getCategories();
		modelMap.addAttribute("categories", categories);
		
		List<ProductSize> productSizes = productSizeService.getProductSizes();
		modelMap.addAttribute("productSizes", productSizes);

		List<ProductColor> productColors = productColorService.getProductColors();
		modelMap.addAttribute("productColors", productColors);
		
		return "addproduct";
	}
}
