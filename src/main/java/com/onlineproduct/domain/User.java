package com.onlineproduct.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	@Size(min =  6, max = 15, message = "Your username must in between 6 and 15 characters.")
	private String username;
	
	@Size(min = 6, max  = 15, message = "Your password must in bewteen 6 and 15 characters.")
	private String password;
	
	@Pattern(regexp = "[a-zA-z ]*")
	@NotEmpty(message  = "Please enter your name. Make sure that you enter only alphabets and space.")
	private String name;
	
	@NotEmpty(message = "Please enter your email")
	@Email(message = "Your email is incorrect")
	private String email;
	
	@NotNull
	@Min(value = 1, message = "The value must be positive")
	@Range(min=1111111,max=999999999)
	private int contact;
	
	@NotEmpty(message  = "Address cannot be empty")
	@Size(max = 50,  message = "Address cannot be more than 50 characters")
	private String address;
	
	@NotNull(message = "Date of birth cannot be empty")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	@Past(message = "Date of birth cannot be greater than or equal to current date")
	private Date dateOfBirth;
	
	@NotNull(message = "Gender is required")
	private String sex;
	
	private String status;
	
	public User() {};
	
	public User(String username, String password, 
			String name, String sex, String email, int contact, 
			String address,
			Date dateOfBirth, String status) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
