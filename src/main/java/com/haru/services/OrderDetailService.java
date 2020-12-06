package com.haru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.OrderDetailDAOImpl;
import com.haru.daos.IOrderDetailDAO;
import com.haru.entities.OrderDetail;

@Service
public class OrderDetailService implements IOrderDetailDAO {

	@Autowired
	OrderDetailDAOImpl orderDetailDAOImpl;

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		return orderDetailDAOImpl.addOrderDetail(orderDetail);
	}

}
