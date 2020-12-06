package com.haru.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double price;
	private String description;
	private String image;
	public String dedicated;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	Set<ProductDetail> productDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PromotionalDetail", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId"), inverseJoinColumns = @JoinColumn(name = "promotionalId", referencedColumnName = "promotionalId"))
	Set<Promotional> promotionals;

	public Product() {
	}

	public Product(String productName, double price, String description, String image, Category category) {
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
	}

	public Product(int productId, String productName, double price, String description, String image,
			Category category) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.image = image;
		this.category = category;
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", description=" + description + ", image=" + image + ", category=" + category + "]";
	}

}
