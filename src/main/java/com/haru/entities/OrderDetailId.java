package com.haru.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable {

	private static final long serialVersionUID = 6871831787923929853L;
	private int orderId;
	private int productDetailId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		result = prime * result + productDetailId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailId other = (OrderDetailId) obj;
		if (orderId != other.orderId)
			return false;
		if (productDetailId != other.productDetailId)
			return false;
		return true;
	}

}
