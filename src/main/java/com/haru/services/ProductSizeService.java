package com.haru.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.ProductSizeDAOImpl;
import com.haru.daos.IProductSizeDAO;
import com.haru.entities.ProductSize;

@Service
public class ProductSizeService implements IProductSizeDAO {

	@Autowired
	ProductSizeDAOImpl productSizeDAOImpl;

	@Override
	public List<ProductSize> getProductSizes() {
		return productSizeDAOImpl.getProductSizes();
	}

}
