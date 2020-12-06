package com.haru.daoimpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IProductDAO;
import com.haru.entities.Product;
import com.haru.entities.ProductDetail;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> getListProductLimit(int rowBegins) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList<Product>();
		if (rowBegins < 0) {
			/**
			 * all product
			 */
			String query = "FROM Product";
			products = (List<Product>) session.createQuery(query).getResultList();
		}
//		else if (rowBegins == -1) {
//			/**
//			 * product hot
//			 */
//			products = (List<Product>) session.createQuery("from Product").setFirstResult(0).setMaxResults(20)
//					.getResultList();
//		} 
		else {
			/**
			 * product to pagination
			 */
			products = (List<Product>) session.createQuery("from Product").setFirstResult(rowBegins).setMaxResults(5)
					.getResultList();
		}
		return products;
	}

	@Override
	@Transactional
	public Product getProductByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		String query = "FROM Product p where p.productId=" + productId;
		Product product = (Product) session.createQuery(query).getSingleResult();
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> getProductsByCategoryId(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		String query = "FROM Product p where p.category.categoryId=" + categoryId;
		List<Product> products = (List<Product>) session.createQuery(query).getResultList();
		return products;
	}

	@Override
	@Transactional
	public boolean deleteProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);

		Set<ProductDetail> productDetails = product.getProductDetails();
		for (ProductDetail productDetail : productDetails) {
			session.createQuery("delete OrderDetail where productdetailId=" + productDetail.getProductDetailId())
					.executeUpdate();
		}
		session.createQuery("delete promotionaldetail where productId=" + productId).executeUpdate();
		session.createQuery("delete ProductDetail where productId=" + productId).executeUpdate();
		session.createQuery("delete Product where productId=" + productId).executeUpdate();
		return true;
	}

	@Override
	@Transactional
	public boolean addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		return true;
	}

	@Override
	@Transactional
	public boolean updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		return true;
	}

}
