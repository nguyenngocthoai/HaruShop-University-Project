package com.haru.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductSize {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productSizeId;
	private String size;

	public ProductSize() {
	}

	public ProductSize(String size) {
		this.size = size;
	}

	public ProductSize(int productSizeId, String size) {
		this.productSizeId = productSizeId;
		this.size = size;
	}

	public int getProductSizeId() {
		return productSizeId;
	}

	public void setProductSizeId(int productSizeId) {
		this.productSizeId = productSizeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ProductSize [productSizeId=" + productSizeId + ", size=" + size + "]";
	}

}
