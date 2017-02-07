package com.onlineproduct.domain;

import java.util.Date;

import com.mysql.cj.jdbc.Blob;

public class Product {
	private String name;
	private String userId;
	private Blob image;
	private double price;
	private Date dateManufacture;
	private Date dateAdded;
	private String category;
	private String description;
	
	public Product(){
		
	}
	
	
	public Product(String name, String userId, Blob image, double price, Date dateManufacture,
			Date dateAdded, String category, String description) {
		super();
		this.name = name;
		this.userId = userId;
		this.image = image;
		this.price = price;
		this.dateManufacture = dateManufacture;
		this.dateAdded = dateAdded;
		this.category = category;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateManufacture() {
		return dateManufacture;
	}
	public void setDateManufacture(Date dateManufacture) {
		this.dateManufacture = dateManufacture;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
