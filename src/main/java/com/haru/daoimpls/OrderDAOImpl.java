package com.haru.daoimpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IOrderDAO;
import com.haru.entities.Order;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderDAOImpl implements IOrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int addOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		int id =  (int) session.save(order);
		if (id > 0) {
			return id;
		} else {
			return 0;
		}
	}

}
