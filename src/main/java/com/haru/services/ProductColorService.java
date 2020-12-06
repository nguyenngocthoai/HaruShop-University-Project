package com.haru.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.ProductColorDAOImpl;
import com.haru.daos.IProductColorDAO;
import com.haru.entities.ProductColor;

@Service
public class ProductColorService implements IProductColorDAO {
	@Autowired
	ProductColorDAOImpl productColorDAOImpl;

	@Override
	public List<ProductColor> getProductColors() {
		return productColorDAOImpl.getProductColors();
	}

}
