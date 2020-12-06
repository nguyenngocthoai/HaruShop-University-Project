package com.haru.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderDetail {
	@EmbeddedId
	private OrderDetailId orderDetailId;
	private int quantity;
	private double price;

	public OrderDetail() {
	}

	public OrderDetail(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public OrderDetail(OrderDetailId orderDetailId, int quantity, double price) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderDetailId getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(OrderDetailId orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
