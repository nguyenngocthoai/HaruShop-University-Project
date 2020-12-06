package com.haru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haru.daoimpls.EmployeeDAOImpl;
import com.haru.daos.IEmployeeDAO;
import com.haru.entities.Employee;

@Service
public class EmployeeService implements IEmployeeDAO {

	@Autowired
	EmployeeDAOImpl employeeDAOImpl;

	@Override
	public boolean handleLogin(String email, String password) {
		boolean check = employeeDAOImpl.handleLogin(email, password);
		return check;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean checkAddEmployee=employeeDAOImpl.addEmployee(employee);
		return checkAddEmployee;
	}

}
