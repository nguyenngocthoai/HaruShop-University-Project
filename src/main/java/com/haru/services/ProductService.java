package com.haru.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.ProductDAOImpl;
import com.haru.daos.IProductDAO;
import com.haru.entities.Product;

@Service
public class ProductService implements IProductDAO {

	@Autowired
	ProductDAOImpl productDAOImpl;

	@Override
	public List<Product> getListProductLimit(int rowBegins) {
		return productDAOImpl.getListProductLimit(rowBegins);
	}

	@Override
	public Product getProductByProductId(int productId) {
		return productDAOImpl.getProductByProductId(productId);
	}

	@Override
	public List<Product> getProductsByCategoryId(int categoryId) {
		return productDAOImpl.getProductsByCategoryId(categoryId);
	}

	@Override
	public boolean deleteProductById(int productId) {
		return productDAOImpl.deleteProductById(productId);
	}

	@Override
	public boolean addProduct(Product product) {
		return productDAOImpl.addProduct(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		return productDAOImpl.updateProduct(product);
	}

}
