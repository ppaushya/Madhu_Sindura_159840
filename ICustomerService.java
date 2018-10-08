package org.mno.service;

import java.util.List;
import java.util.Set;

import org.mno.model.Account;
import org.mno.model.Customer;
import org.mno.model.Transaction;

public interface ICustomerService {
	
	public List<Customer> getCustomersList();
	public void createCustomer(Customer customer);
	public void createAccount(Account account,Customer customer);
	public Set<Account> getAccountList(Customer selectedCustomer);
	public void createTransaction(Transaction transaction, Account account);
	public void debitAmount(Account selectedAccount,double amount);
	public void creditAmount(Account selectedAccount,double amount);
	public void TransferAmount(Account selectedAccount, Account selectedToAccount,double amount);
	
}
