package com.haru.daos;

import java.util.List;

import com.haru.entities.Product;

public interface IProductDAO {

	public List<Product> getListProductLimit(int rowBegins);

	public Product getProductByProductId(int productId);

	public List<Product> getProductsByCategoryId(int categoryId);

	public boolean deleteProductById(int productId);

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

}
