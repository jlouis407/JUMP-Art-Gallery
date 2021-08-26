package com.cognixia.jump.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotNull
	private double price;
	
	@NotNull
	private LocalDate datePurchased;
	
	public Order() {
		this(-1L, "N/A", "N/A", "N/A", 0.0, LocalDate.now());
	}
	
	public Order(Long id, String title, String firstName, String lastName, double price, LocalDate datePurchased) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.price = price;
		this.datePurchased = datePurchased;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(LocalDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", price=" + price + ", datePurchased=" + datePurchased + "]";
	}
	
	
	
	

}
