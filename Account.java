package org.mno.model;

import java.time.LocalDate;
import java.util.List;

public class Account {
	
	private long accountNumber;
	private AccountType accountType;
	private LocalDate openingdate;
	private double openingBalance;
	private String description;
	private double balance;
	private List<Transaction> transaction;

	public Account() {
		super();
	}
	
	public Account(long accountNumber, AccountType accountType, LocalDate openingdate, double openingBalance,
			String description,double balance, List<Transaction> transaction) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingdate = openingdate;
		this.openingBalance = openingBalance;
		this.description = description;
		this.balance = 0;
		this.transaction = transaction;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", openingdate="
				+ openingdate + ", openingBalance=" + openingBalance + ", description=" + description + "]";
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningdate() {
		return openingdate;
	}
	public void setOpeningdate(LocalDate openingdate) {
		this.openingdate = openingdate;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	
}
