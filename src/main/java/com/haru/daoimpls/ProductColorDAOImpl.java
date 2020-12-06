package com.haru.daoimpls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IProductColorDAO;
import com.haru.entities.ProductColor;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductColorDAOImpl implements IProductColorDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ProductColor> getProductColors() {
		Session session=sessionFactory.getCurrentSession();
		String query="from ProductColor";
		List<ProductColor> productColors=session.createQuery(query).getResultList();
		return productColors;
	}

}
