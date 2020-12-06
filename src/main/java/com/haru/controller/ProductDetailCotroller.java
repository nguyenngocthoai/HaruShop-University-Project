package com.haru.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haru.entities.Cart;
import com.haru.entities.Category;
import com.haru.entities.Product;
import com.haru.services.CategoryService;
import com.haru.services.ProductService;

@Controller
@RequestMapping("detail/")
@SessionAttributes("cart")
public class ProductDetailCotroller {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@SuppressWarnings("unchecked")
	@GetMapping("{productId}")
	public String detailDefault(@PathVariable int productId, ModelMap modelMap, HttpSession httpSession) {
		Product product = productService.getProductByProductId(productId);
		modelMap.addAttribute("product", product);

		List<Category> categories = categoryService.getCategories();
		modelMap.addAttribute("categories", categories);

		if (null != httpSession.getAttribute("cart")) {
			List<Cart> qualityCarts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("qualityCarts", qualityCarts.size());
		}

		return "detail";
	}

}
