package com.haru.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.CategoryDAOImpl;
import com.haru.daos.ICategotyDAO;
import com.haru.entities.Category;

@Service
public class CategoryService implements ICategotyDAO {

	@Autowired
	CategoryDAOImpl categoryDAOImpl;

	@Override
	public List<Category> getCategories() {
		return categoryDAOImpl.getCategories();
	}

}
