package com.maxtrain.bootcamp.spring.account;

import java.time.LocalDate;

import com.maxtrain.bootcamp.spring.customer.Customer;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(length=30, nullable=false)
	private String Type = "";
	@Column(length=80, nullable=false)
	private String Description = "";
	@Column(columnDefinition="decimal(11,2) not null")
	private double InterestRate = 0.01;
	@Column(columnDefinition="decimal(11,2) not null")
	private double Balance = 0;
	@Column(columnDefinition="datetime not null")
	private LocalDate CreatedDate = java.time.LocalDate.now();
	@Column(columnDefinition="datetime not null")
	private LocalDate ModifiedDate = java.time.LocalDate.now();

	@ManyToOne(optional=false)
	@JoinColumn(name="customerId")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
