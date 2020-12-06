package com.haru.daos;

import com.haru.entities.Employee;

public interface IEmployeeDAO {

	public boolean handleLogin(String email, String password);

	public boolean addEmployee(Employee employee);

}
