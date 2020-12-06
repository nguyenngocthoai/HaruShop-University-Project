package com.haru.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haru.entities.Category;
import com.haru.entities.Product;
import com.haru.services.CategoryService;
import com.haru.services.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping
	@Transactional
	public String homeDefault(ModelMap modelMap, HttpSession httpSession) {
		if (httpSession.getAttribute("email") != null) {
			String user = (String) httpSession.getAttribute("email");
			String userNameLoginAvatar = user.substring(0, 1).toUpperCase();
			modelMap.addAttribute("userNameLoginAvatar", userNameLoginAvatar);
		}
		List<Product> products = productService.getListProductLimit(-1);
		modelMap.addAttribute("products", products);

//		if (null != httpSession.getAttribute("cart")) {
//			List<Cart> qualityCarts = (List<Cart>) httpSession.getAttribute("cart");
//			modelMap.addAttribute("qualityCarts", qualityCarts.size());
//		}
		
		List<Category> categories = categoryService.getCategories();
		modelMap.addAttribute("categories", categories);

		return "home";
//		Session session = sessionFactory.getCurrentSession();
		/**
		 * get all Employees from database
		 */
//		String sql = "from NhanVien";
//		List<NhanVien> listNhanVien = session.createQuery(sql).getResultList();
//		listNhanVien.forEach(x -> {
//			System.out.println(x);
//		});

		/**
		 * One to One
		 */
//		SanPham sp=new SanPham("Ao thun", 100000);
//		NhanVien nv=new  NhanVien("Nguyen Ngoc Thoai", 21);
//		sp.setNhanVien(nv);
//		session.save(sp);

		/**
		 * One to Many
		 */
//		SanPham sp1 = new SanPham("Quan Jean", 1000000);
//		SanPham sp2 = new SanPham("Quan Kaki", 500000);
//		SanPham sp3 = new SanPham("Ao Khoac", 300000);
//		Set<SanPham> sanPhams = new HashSet<SanPham>();
//		sanPhams.add(sp1);
//		sanPhams.add(sp2);
//		sanPhams.add(sp3);
//
//		NhanVien nv = new NhanVien("Nguyen Thi Ngoc T", 21);
//		nv.setProducts(sanPhams);
//		session.save(nv);

		/**
		 * Many to Many
		 */
//		NhanVien nv1 = new NhanVien("Nguyen Ngoc Thoai", 21);
//		NhanVien nv2 = new NhanVien("Nguyen Thanh Lien", 20);
//		NhanVien nv3 = new NhanVien("Le Van Quang", 23);
//		Set<NhanVien> nhanViens=new HashSet<NhanVien>();
//		nhanViens.add(nv1);
//		nhanViens.add(nv2);
//		nhanViens.add(nv3);
//		
//		SanPham sp=new SanPham("Ao Trang", 600000);
//		sp.setNhanViens(nhanViens);
//		session.save(sp);

	}

	/**
	 * add Employee
	 * 
	 * @param name
	 * @param age
	 * @return "home"
	 */
//	@PostMapping
//	@Transactional
//	public String addEmployee(@RequestParam String name, @RequestParam int age) {
//		Session session = sessionFactory.getCurrentSession();
//		NhanVien employee = new NhanVien(name, age);
//		session.save(employee);
//		return "home";
//	}

	/**
	 * update Employee way 1
	 * 
	 * @return "home"
	 */
//	@GetMapping
//	@Transactional
//	public String updateEmployee() {
//		Session session = sessionFactory.getCurrentSession();
//		NhanVien employee = (NhanVien) session.createQuery("from NhanVien where id=4").uniqueResult();
//		employee.setAgel(20);
//		session.update(employee);
//		return "home";
//	}

	/**
	 * update Employee way 2
	 * 
	 * @return "home"
	 */
//	@PostMapping
//	@Transactional
//	public String updateEmployee() {
//		Session session = sessionFactory.getCurrentSession();
//		NhanVien employee = session.get(NhanVien.class, 4);
//		employee.setAgel(21);
//		session.update(employee);
//		return "home";
//	}

}
