package com.haru.daoimpls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.ICategotyDAO;
import com.haru.entities.Category;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryDAOImpl implements ICategotyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Category> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from Category";
		@SuppressWarnings("unchecked")
		List<Category> categories = session.createQuery(query).getResultList();
		return categories;
	}

}
