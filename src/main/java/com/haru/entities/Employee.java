package com.haru.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	private String address;
	private boolean gender;
	private String identityCard;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	private Role role;

	public Employee() {
	}

	public Employee(int employeeId, String employeeName, String address, boolean gender, String identityCard,
			String email, String phoneNumber, String userName, String password, Role role) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.gender = gender;
		this.identityCard = identityCard;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Employee(String employeeName, String address, boolean gender, String identityCard, String email,
			String phoneNumber, String userName, String password, Role role) {
		this.employeeName = employeeName;
		this.address = address;
		this.gender = gender;
		this.identityCard = identityCard;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", address=" + address
				+ ", gender=" + gender + ", identityCard=" + identityCard + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
