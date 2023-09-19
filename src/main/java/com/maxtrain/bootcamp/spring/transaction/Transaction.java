package com.maxtrain.bootcamp.spring.transaction;

import java.time.LocalDate;

import com.maxtrain.bootcamp.spring.account.Account;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@Column(columnDefinition="decimal(11,2) not null")
	private double previousBalance;
	@Column(length=30, nullable=false)
	private String transactionType;
	@Column(columnDefinition="decimal(11,2) not null")
	private double newBalance;
	@Column(length=30, nullable=false)
	private String description;
	@Column(columnDefinition="datetime not null")
	private LocalDate createdDate = java.time.LocalDate.now();
	
	@ManyToOne(optional=false)
	@JoinColumn(name="accountId")
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
