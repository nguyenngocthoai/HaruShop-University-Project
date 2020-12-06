package com.haru.daoimpls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IProductSizeDAO;
import com.haru.entities.ProductSize;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductSizeDAOImpl implements IProductSizeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProductSize> getProductSizes() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from ProductSize";
		List<ProductSize> productSizes = session.createQuery(query).getResultList();
		return productSizes;
	}

}
