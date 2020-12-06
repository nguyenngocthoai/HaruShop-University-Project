package com.haru.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Promotional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promotionalId;
	private String promotionalName;
	private Date startday;
	private Date endday;
	private int discount;
	private String description;
	private String image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PromotionalDetail",
		joinColumns = @JoinColumn(name = "promotionalId", referencedColumnName = "promotionalId"),
		inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId"))
	Set<Product> products;

	public Promotional() {
	}

	public Promotional(String promotionalName, Date startday, Date endday, int discount, String description,
			String image) {
		this.promotionalName = promotionalName;
		this.startday = startday;
		this.endday = endday;
		this.discount = discount;
		this.description = description;
		this.image = image;
	}

	public Promotional(int promotionalId, String promotionalName, Date startday, Date endday, int discount,
			String description, String image) {
		this.promotionalId = promotionalId;
		this.promotionalName = promotionalName;
		this.startday = startday;
		this.endday = endday;
		this.discount = discount;
		this.description = description;
		this.image = image;
	}

	public int getPromotionalId() {
		return promotionalId;
	}

	public void setPromotionalId(int promotionalId) {
		this.promotionalId = promotionalId;
	}

	public String getPromotionalName() {
		return promotionalName;
	}

	public void setPromotionalName(String promotionalName) {
		this.promotionalName = promotionalName;
	}

	public Date getStartday() {
		return startday;
	}

	public void setStartday(Date startday) {
		this.startday = startday;
	}

	public Date getEndday() {
		return endday;
	}

	public void setEndday(Date endday) {
		this.endday = endday;
	}

	public String getDescription() {
		return description;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Promotional [promotionalId=" + promotionalId + ", promotionalName=" + promotionalName + ", startday="
				+ startday + ", endday=" + endday + ", discount=" + discount + ", description=" + description
				+ ", image=" + image + "]";
	}

}
