package com.haru.daoimpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IOrderDetailDAO;
import com.haru.entities.OrderDetail;
import com.haru.entities.OrderDetailId;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderDetailDAOImpl implements IOrderDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addOrderDetail(OrderDetail orderDetail) {
		Session session = sessionFactory.getCurrentSession();
		OrderDetailId id = (OrderDetailId) session.save(orderDetail);
		if (id != null) {
			return true;
		} else {
			return false;
		}
	}

}
