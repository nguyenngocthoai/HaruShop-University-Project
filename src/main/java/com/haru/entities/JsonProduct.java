package com.haru.entities;

import java.util.Set;

public class JsonProduct {
	private int productId;
	private String productName;
	private double price;
	private String description;
	private String image;
	public String dedicated;

	private Category category;
	Set<ProductDetail> productDetails;
	Set<Promotional> promotionals;

	public JsonProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDedicated() {
		return dedicated;
	}

	public void setDedicated(String dedicated) {
		this.dedicated = dedicated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Set<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public Set<Promotional> getPromotionals() {
		return promotionals;
	}

	public void setPromotionals(Set<Promotional> promotionals) {
		this.promotionals = promotionals;
	}

}
