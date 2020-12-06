package com.haru.entities;

public class Cart {

	private int productId;
	private int productDetailId;
	private String productName;
	private int colorId;
	private String colorName;
	private int sizeId;
	private String size;
	private double price;
	private int quality;
	private String image;

	public Cart() {
	}

	public Cart(int productId, String productName, int colorId, String colorName, int sizeId, String size, double price,
			int quality, String image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.colorId = colorId;
		this.colorName = colorName;
		this.sizeId = sizeId;
		this.size = size;
		this.price = price;
		this.quality = quality;
		this.image = image;
	}

	public Cart(int productId, String productName, int colorId, String colorName, int sizeId, String size, double price,
			int quality, String image, int productDetailId) {
		super();
		this.productId = productId;
		this.productDetailId = productDetailId;
		this.productName = productName;
		this.colorId = colorId;
		this.colorName = colorName;
		this.sizeId = sizeId;
		this.size = size;
		this.price = price;
		this.quality = quality;
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
