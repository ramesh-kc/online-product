package com.onlineproduct.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	@NotEmpty(message = "Product name can not be empty.")
	private String name;
	
	private int userId;
	
	private MultipartFile image;
	
	
	@Min(value = 0, message = "The value must be positive.")
	@NotNull(message = "Price should not be null.")
	private double price;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	@Past(message = "Manufacture date should be greater than today.")
	private Date dateManufacture;
	
	private Date dateAdded;
	
	@NotNull(message = "Category can not be empty.")
	private String category;
	
	@Size(min = 10, message = "Description should be at least 10 character long.")
	private String description;
	
	private int productId;
	
	private String imageName;
	

	public Product(){}
	
	public Product(int productId, String name, int userId, MultipartFile image, double price, Date dateManufacture,
			Date dateAdded, String category, String description, String imageName) {
		super();
		this.productId = productId;
		this.name = name;
		this.userId = userId;
		this.image = image;
		this.price = price;
		this.dateManufacture = dateManufacture;
		this.dateAdded = dateAdded;
		this.category = category;
		this.description = description;
		this.imageName = imageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
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
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
