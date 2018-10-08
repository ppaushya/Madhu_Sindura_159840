package org.mno.dao;

import java.util.List;

import org.mno.model.Account;
import org.mno.model.Customer;
import org.mno.model.Transaction;

public interface ICustomerDao {

	public List<Customer> getCustomersList();
	public void createCustomer(Customer customer);
	public void createAccount(Account account, Customer customer);
	public void createTransaction(Transaction transaction, Account account);
}
