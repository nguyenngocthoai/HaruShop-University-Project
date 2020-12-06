package com.haru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.OrderDAOImpl;
import com.haru.daos.IOrderDAO;
import com.haru.entities.Order;

@Service
public class OrderService implements IOrderDAO {

	@Autowired
	OrderDAOImpl orderDAOImpl;

	@Override
	public int addOrder(Order order) {
		return orderDAOImpl.addOrder(order);
	}

}
