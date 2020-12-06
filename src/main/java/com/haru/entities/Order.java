package com.haru.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String customerName;
	private String phoneNumber;
	private String deliveryAddress;
	private boolean status;
	private Date orderdate;
	private String formOfDelivery;
	private String note;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	Set<OrderDetail> orderDetails;

	public Order() {
	}

	public Order(String customerName, String phoneNumber, String deliveryAddress, boolean status, Date orderdate,
			String formOfDelivery, String note, Set<OrderDetail> orderDetails) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.orderdate = orderdate;
		this.formOfDelivery = formOfDelivery;
		this.note = note;
		this.orderDetails = orderDetails;
	}

	public Order(String customerName, String phoneNumber, String deliveryAddress, String formOfDelivery, String note) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.formOfDelivery = formOfDelivery;
		this.note = note;
	}
	
	

	public Order(String customerName, String phoneNumber, String deliveryAddress, Date orderdate, String formOfDelivery,
			String note) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.orderdate = orderdate;
		this.formOfDelivery = formOfDelivery;
		this.note = note;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getFormOfDelivery() {
		return formOfDelivery;
	}

	public void setFormOfDelivery(String formOfDelivery) {
		this.formOfDelivery = formOfDelivery;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber
				+ ", deliveryAddress=" + deliveryAddress + ", status=" + status + ", orderdate=" + orderdate + "]";
	}

}
