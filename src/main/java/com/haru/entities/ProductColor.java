package com.haru.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productColorId;
	private String productColorName;

	public ProductColor() {
	}

	public ProductColor(String productColorName) {
		this.productColorName = productColorName;
	}

	public ProductColor(int productColorId, String productColorName) {
		this.productColorId = productColorId;
		this.productColorName = productColorName;
	}

	public int getproductColorId() {
		return productColorId;
	}

	public void setproductColorId(int productColorId) {
		this.productColorId = productColorId;
	}

	public String getproductColorName() {
		return productColorName;
	}

	public void setproductColorName(String productColorName) {
		this.productColorName = productColorName;
	}

	@Override
	public String toString() {
		return "ColorProduct [productColorId=" + productColorId + ", productColorName=" + productColorName + "]";
	}

}
