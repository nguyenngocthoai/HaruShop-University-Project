package com.haru.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haru.entities.Cart;
import com.haru.entities.Category;
import com.haru.entities.JsonProduct;
import com.haru.entities.Product;
import com.haru.entities.ProductColor;
import com.haru.entities.ProductDetail;
import com.haru.entities.ProductSize;
import com.haru.services.EmployeeService;
import com.haru.services.ProductService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "email", "cart" })
public class ApiController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProductService productService;

	@Autowired
	ServletContext servletContext;

	@GetMapping("checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		boolean check = employeeService.handleLogin(email, password);
		modelMap.addAttribute("email", email);
		return "" + check;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("addCart")
	@ResponseBody
	public void addCart(@RequestParam int productId, @RequestParam String productName, @RequestParam int colorId,
			@RequestParam String colorName, @RequestParam int sizeId, @RequestParam String size,
			@RequestParam double price, @RequestParam int quality, String image, @RequestParam int detailId,
			HttpSession httpSession) {

		if (null == httpSession.getAttribute("cart")) {
			List<Cart> carts = new ArrayList<Cart>();
			Cart cart = new Cart(productId, productName, colorId, colorName, sizeId, size, price, 1, image, detailId);
			carts.add(cart);
			httpSession.setAttribute("cart", carts);
		} else {
			int index = checkProductExistedCart(productId, sizeId, colorId, httpSession);
			if (index == -1) {
				List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
				Cart cart = new Cart(productId, productName, colorId, colorName, sizeId, size, price, 1, image,
						detailId);
				carts.add(cart);
			} else {
				List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
				int newQuality = carts.get(index).getQuality() + 1;
				carts.get(index).setQuality(newQuality);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private int checkProductExistedCart(int productId, int sizeId, int colorId, HttpSession httpSession) {
		List<Cart> list = (List<Cart>) httpSession.getAttribute("cart");
		for (Cart cart : list) {
			if (cart.getProductId() == productId && cart.getSizeId() == sizeId && cart.getColorId() == colorId) {
				return list.indexOf(cart);
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("getQualityCart")
	@ResponseBody
	public String getQualityCart(HttpSession httpSession) {
		if (null != httpSession.getAttribute("cart")) {
			List<Cart> qualityCarts = (List<Cart>) httpSession.getAttribute("cart");
			return qualityCarts.size() + "";
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("updateCart")
	@ResponseBody
	public void updateCart(HttpSession httpSession, @RequestParam int quality, @RequestParam int productId,
			@RequestParam int colorId, @RequestParam int sizeId) {
		if (null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = checkProductExistedCart(productId, sizeId, colorId, httpSession);
			carts.get(index).setQuality(quality);
		}
	}

	@SuppressWarnings("unchecked")
	@GetMapping("deleteCart")
	@ResponseBody
	public void deleteCart(HttpSession httpSession, @RequestParam int productId, @RequestParam int colorId,
			@RequestParam int sizeId) {
		if (null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = checkProductExistedCart(productId, sizeId, colorId, httpSession);
			carts.remove(index);
		}
	}

	@GetMapping(path = "getProductLimit", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getProductLimit(@RequestParam int beginsProduct) {
		String html = "";
		List<Product> products = productService.getListProductLimit(beginsProduct);
		for (Product product : products) {
			html += "<tr>";
			html += "<td><label><input class='checkbox-product' type='checkbox'+ value='" + product.getProductId()
					+ "'></label></td>";
			html += "<td class='image text-dark'>";
//			<img class='image-admin' src='<c:url value='/resources/images/product/${product.image}'/>'>
//			<img class='image-admin' src='/resources/images/product/${product.image}'>
//			html += "<img class='image-admin' src="+"'<c:url value='/resources/images/product/" + product.getImage()
//					+ "'/>'>";
			html+="<img class='image-admin' src='/harushop/resources/images/product/"+product.getImage()+"'>";
			html += "</td>";
			html += "<td class='name text-cart productName text-dark' data-productId=" + product.getProductId() + ">"
					+ product.getProductName() + "</td>";
			html += "<td class='price text-danger text-cart text-dark'>" + product.getPrice() + "00 VND" + "</td>";
			html += "<td class='dedicated text-danger'>" + product.getDedicated() + "</td>";
			html += "<td class='update-product btn btn-warning text-white' data-id=" + product.getProductId()
					+ ">Sửa</td>";
			html += "</tr>";
		}
		System.out.println(html);
		return html;
	}

	@GetMapping("deleteProduct")
	@ResponseBody
	public String deleteProductById(@RequestParam int productId) {
		productService.deleteProductById(productId);
		return "true";
	}

	@PostMapping("uploadFile")
	@ResponseBody
	/**
	 * MultipartHttpServletRequest get request of form data and get request of tag
	 * form
	 * 
	 * @param request
	 * @return
	 */
	public String uploadFile(MultipartHttpServletRequest request) {
		/**
		 * the real path on the server
		 */
		String PATH_SAVE_FILE = servletContext.getRealPath("/resources/images/product/");
		/**
		 * get file
		 */
		Iterator<String> listNames = request.getFileNames();
		/**
		 * get file name
		 */
		MultipartFile multipartFile = request.getFile(listNames.next());

		File file_save = new File(PATH_SAVE_FILE + multipartFile.getOriginalFilename());
		try {
			/**
			 * transfer file in to the real path on the server
			 */
			multipartFile.transferTo(file_save);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(PATH_SAVE_FILE);
		return "true";
	}

	@PostMapping("addProduct")
	@ResponseBody
	public void addProduct(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			Product product = new Product();

			jsonObject = objectMapper.readTree(dataJson);

			Category category = new Category();
			category.setCategoryId(jsonObject.get("category").asInt());

			JsonNode jsonDetail = jsonObject.get("productDetails");
			Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
			for (JsonNode pd : jsonDetail) {
				ProductDetail productDetail = new ProductDetail();

				ProductColor productColor = new ProductColor();
				productColor.setproductColorId(pd.get("productColor").asInt());

				ProductSize productSize = new ProductSize();
				productSize.setProductSizeId(pd.get("size").asInt());

				productDetail.setProductColor(productColor);
				productDetail.setProductSize(productSize);

				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				productDetail.setDateRecive(date);
				productDetail.setQuantity(pd.get("quality").asInt());

				productDetails.add(productDetail);
			}

			String productName = jsonObject.get("productName").asText();
			double price = jsonObject.get("price").asDouble();
			String description = jsonObject.get("description").asText();
			String image = jsonObject.get("image").asText();
			String dedicated = jsonObject.get("dedicated").asText();

			product.setProductName(productName);
			product.setPrice(price);
			product.setDescription(description);
			product.setImage(image);
			product.setDedicated(dedicated);
			product.setProductDetails(productDetails);
			product.setCategory(category);

			productService.addProduct(product);
			System.out.println(product);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@PostMapping(path = "getListProductById", produces = "Application/json;charset=utf-8")
	@ResponseBody
	public JsonProduct getListProductById(@RequestParam int productId) {
		Product product = productService.getProductByProductId(productId);

		JsonProduct jsonProduct = new JsonProduct();
		jsonProduct.setProductId(product.getProductId());
		jsonProduct.setProductName(product.getProductName());
		jsonProduct.setPrice(product.getPrice());
		jsonProduct.setDescription(product.getDescription());
		jsonProduct.setImage(product.getImage());
		jsonProduct.setDedicated(product.getDedicated());

		Category category = new Category();
		category.setCategoryId(product.getCategory().getCategoryId());
		category.setCategoryName(product.getCategory().getCategoryName());
		category.setImage(product.getCategory().getImage());
		jsonProduct.setCategory(category);

		Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
		for (ProductDetail value : product.getProductDetails()) {
			ProductDetail productDetail = new ProductDetail();

			productDetail.setProductDetailId(value.getProductDetailId());

			ProductColor productColor = new ProductColor();
			productColor.setproductColorId(value.getProductColor().getproductColorId());
			productColor.setproductColorName(value.getProductColor().getproductColorName());

			productDetail.setProductColor(productColor);

			ProductSize productSize = new ProductSize();
			productSize.setProductSizeId(value.getProductSize().getProductSizeId());
			productSize.setSize(value.getProductSize().getSize());

			productDetail.setProductSize(productSize);
			productDetail.setQuantity(value.getQuantity());
			productDetail.setDateRecive(value.getDateRecive());
			System.out.println(value.getDateRecive());
			productDetails.add(productDetail);
		}
		jsonProduct.setProductDetails(productDetails);

		return jsonProduct;
	}

	/**
	 * update product
	 * function error
	 * @param dataJson
	 */
	@PostMapping("updateProduct")
	@ResponseBody
	public void updateProduct(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		try {
			Product product = new Product();

			jsonObject = objectMapper.readTree(dataJson);

			Category category = new Category();
			category.setCategoryId(jsonObject.get("category").asInt());

			JsonNode jsonDetail = jsonObject.get("productDetails");
			Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
			for (JsonNode pd : jsonDetail) {
				ProductDetail productDetail = new ProductDetail();

				ProductColor productColor = new ProductColor();
				productColor.setproductColorId(pd.get("productColor").asInt());

				ProductSize productSize = new ProductSize();
				productSize.setProductSizeId(pd.get("size").asInt());

//				productDetail.setProductDetailId(jsonObject.get("productId").asInt());
				productDetail.setProductColor(productColor);
				productDetail.setProductSize(productSize);
//				productDetail.setProductDetailId(pd.get("productDetail").asInt());
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				productDetail.setDateRecive(date);
				productDetail.setQuantity(pd.get("quality").asInt());

				productDetails.add(productDetail);
			}

			String productName = jsonObject.get("productName").asText();
			double price = jsonObject.get("price").asDouble();
			String description = jsonObject.get("description").asText();
			String image = jsonObject.get("image").asText();
			String dedicated = jsonObject.get("dedicated").asText();
			int productId = jsonObject.get("productId").asInt();

			product.setProductId(productId);
			product.setProductName(productName);
			product.setPrice(price);
			product.setDescription(description);
			product.setImage(image);
			product.setDedicated(dedicated);
			product.setProductDetails(productDetails);
			product.setCategory(category);

			productService.updateProduct(product);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
