package com.haru.daoimpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haru.daos.IEmployeeDAO;
import com.haru.entities.Employee;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean handleLogin(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employee employee = (Employee) session
					.createQuery("from Employee where email='" + email + "' and password='" + password + "'")
					.getSingleResult();
			if (employee != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(employee);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

}
