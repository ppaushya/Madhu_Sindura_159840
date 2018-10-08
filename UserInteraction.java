package org.mno.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.mno.model.Account;
import org.mno.model.Customer;
import org.mno.model.Transaction;
import org.mno.util.Utility;

public class UserInteraction {
	
	public Customer getCustomerDetails() {
		
		Customer customer=new Customer();
		
		customer.setCustomerId(Utility.generateNumber());
		customer.setFirstName(Utility.promptFirstName());
		customer.setLastName(Utility.promptLastName());
		customer.setEmailId(Utility.promptEmailId());
		customer.setMobileNo(Utility.promptMobileNo());
		customer.setDateOfBirth(Utility.promptDate());
		customer.setAddress(Utility.promptAddress());
		return customer;
	}

	public void printCustomers(List<Customer> customers) {
		System.out.println("List of customers:");
		System.out.println("CustomerId\tCustomerName\tMobileNumber\tEmailId");
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getFirstName()+customer.getLastName()+"\t"+customer.getMobileNo()+"\t"+customer.getEmailId());
		
		}
			
	
	}

	public Account getAccountDetails() {
		
		Account account=new Account();
		
		account.setAccountNumber(Utility.generateAccountNumber());
		account.setAccountType(Utility.promptAccountType());
		account.setOpeningBalance(Utility.promptOpeningBalance());
		account.setOpeningdate(Utility.getOpeningdate());
		account.setDescription(Utility.promptDescription());
		return account;
	}

	public void printAccounts(Set<Account> accounts) {
		System.out.println("List of accounts:");
		System.out.println("AccountNo\tAccountType\tOpeningBalance\tBalance");
		for(Account account:accounts) {
			System.out.println(account.getAccountNumber()+"\t"+account.getAccountType()+account.getOpeningBalance()+"\t"+account.getBalance()+"\t");		
		}
	}
	
	public Transaction getDebitDetails(Account selectedAccount) {
		Transaction transaction=new Transaction();
		
		transaction.setAmount(Utility.generateTransactionID());
		transaction.setTransactionDate(Utility.promptTrasnactionDate());
		transaction.setFromAccount(selectedAccount);
		transaction.setToAccount(selectedAccount, selectedAccount);
		transaction.setAmount(Utility.promptAmount());
		transaction.setDescription(Utility.getDebitDescription());
		return transaction;
	}
	
	public Transaction getCreditDetails(Account selectedAccount) {
		Transaction transaction=new Transaction();
		
		transaction.setAmount(Utility.generateTransactionID());
		transaction.setTransactionDate(Utility.promptTrasnactionDate());
		transaction.setFromAccount(selectedAccount);
		transaction.setToAccount(selectedAccount, selectedAccount);
		transaction.setAmount(Utility.promptAmount());
		transaction.setDescription(Utility.getCreditDescription());
		return transaction;
	}

	public Transaction getTransferDetails(Account selectedAccount,Account selectedToAccount) {
		Transaction transaction=new Transaction();
		
		transaction.setAmount(Utility.generateTransactionID());
		transaction.setTransactionDate(Utility.promptTrasnactionDate());
		transaction.setFromAccount(selectedAccount);
		transaction.setToAccount(selectedAccount, selectedToAccount);
		transaction.setAmount(Utility.promptAmount());
		transaction.setDescription(Utility.getTransferDescription());
		return transaction;
	}

	public void printTransactions(List<Transaction> transaction) {
		System.out.println("List of transactions:");
		System.out.println("TransactionNo\tfromAccount\ttoAccount\tdesciption");
		for(Transaction transactions:transaction) {
			System.out.println(transactions.getTransactionId()+"\t"+transactions.getFromAccount().getAccountNumber()+"\t"+transactions.getToAccount().getAccountNumber()+"\t"+transactions.getDescription());		
		}
	}
	
}
