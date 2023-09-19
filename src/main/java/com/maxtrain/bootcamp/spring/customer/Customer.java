package com.maxtrain.bootcamp.spring.customer;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(length=30, nullable=false)
	private String name = "";
	private int cardCode;
	private int pinCode;
	@Column(columnDefinition="datetime not null")
	private LocalDate CreatedDate = java.time.LocalDate.now();
	@Column(columnDefinition="datetime not null")
	private LocalDate ModifiedDate = java.time.LocalDate.now();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCardCode() {
		return cardCode;
	}
	public void setCardCode(int cardCode) {
		this.cardCode = cardCode;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public LocalDate getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		CreatedDate = createdDate;
	}
	public LocalDate getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	
	
}
