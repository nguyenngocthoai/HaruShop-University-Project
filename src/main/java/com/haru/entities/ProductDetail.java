package com.haru.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productDetailId;
	private int quantity;
	private Date dateRecive;

	@OneToOne()
	@JoinColumn(name = "productId")
	private Product product;

	@OneToOne()
	@JoinColumn(name = "productSizeId")
	private ProductSize productSize;

	@OneToOne()
	@JoinColumn(name = "productColorId")
	private ProductColor productColor;

	public ProductDetail() {
	}

	public ProductDetail(int quantity, Date dateRecive) {
		this.quantity = quantity;
		this.dateRecive = dateRecive;
	}

	public ProductDetail(int productDetailId, int quantity, Date daterecive) {
		this.productDetailId = productDetailId;
		this.quantity = quantity;
		this.dateRecive = daterecive;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateRecive() {
		return dateRecive;
	}

	public void setDateRecive(Date daterecive) {
		this.dateRecive = daterecive;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	public ProductColor getProductColor() {
		return productColor;
	}

	public void setProductColor(ProductColor productColor) {
		this.productColor = productColor;
	}

	@Override
	public String toString() {
		return "ProductDetail [productDetailId=" + productDetailId + ", quantity=" + quantity + ", daterecive="
				+ dateRecive + "]";
	}

}
