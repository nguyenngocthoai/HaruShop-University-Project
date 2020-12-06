package com.haru.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haru.entities.Cart;
import com.haru.entities.Category;
import com.haru.entities.Order;
import com.haru.entities.OrderDetail;
import com.haru.entities.OrderDetailId;
import com.haru.services.CategoryService;
import com.haru.services.OrderDetailService;
import com.haru.services.OrderService;

@Controller
@RequestMapping("cart/")
public class CartController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	CategoryService categoryService;

	@SuppressWarnings("unchecked")
	@GetMapping
	public String cartDefault(HttpSession httpSession, ModelMap modelMap) {
		if (null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("qualityCarts", carts.size());
			modelMap.addAttribute("carts", carts);
		}
		List<Category> categories = categoryService.getCategories();
		modelMap.addAttribute("categories", categories);
		return "cart";
	}

	/**
	 * add order
	 * error utf8 when add to database
	 * @param customerName
	 * @param phoneNumber
	 * @param deliveryAddress
	 * @param formOfDelivery
	 * @param note
	 * @param httpSession
	 * @return "cart"
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(produces = "text/plain;charset=UTF-8")
	public String addOrder(@RequestParam String customerName, @RequestParam String phoneNumber,
			@RequestParam String deliveryAddress, @RequestParam String formOfDelivery, @RequestParam String note,
			HttpSession httpSession) {
		if (null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			if (formOfDelivery.equalsIgnoreCase("on")) {
				formOfDelivery = "Giao hàng tận nơi";
			} else {
				formOfDelivery = "Nhận hàng tại của hàng";
				deliveryAddress = "Nhận hàng tại của hàng";
			}
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			Order order = new Order(customerName, phoneNumber, deliveryAddress, date, formOfDelivery, note);

			int id = orderService.addOrder(order);
			if (id > 0) {
				/* Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(); */
				for (Cart cart : carts) {
					OrderDetailId orderDetailId = new OrderDetailId();
					orderDetailId.setProductDetailId(cart.getProductDetailId());
					orderDetailId.setOrderId(order.getOrderId());

					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setOrderDetailId(orderDetailId);
					orderDetail.setPrice(cart.getPrice());
					orderDetail.setQuantity(cart.getQuality());

					orderDetailService.addOrderDetail(orderDetail);
				}
				System.out.println(order);
			} else {
				System.out.println("no !");
			}
		}
		return "cart";
	}
}
