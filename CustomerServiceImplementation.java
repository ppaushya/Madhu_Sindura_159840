package org.mno.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.mno.dao.CustomerDaoImplementation;
import org.mno.dao.ICustomerDao;
import org.mno.model.Account;
import org.mno.model.Customer;
import org.mno.model.Transaction;

public class CustomerServiceImplementation implements ICustomerService{
	
	ICustomerDao customerDao=new CustomerDaoImplementation();

	@Override
	public List<Customer> getCustomersList() {
		
		List<Customer> customers=customerDao.getCustomersList();
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		
		if(customer.getMobileNo().matches("[789]{1}[0-9]{9}"))  {
			if(customer.getDateOfBirth().isBefore(LocalDate.now()))
		System.out.println("customer");		
		customerDao.createCustomer(customer);
		}
			
		else
		System.out.println("Enter valid customer details");		
		
	}

	@Override
	public void createAccount(Account account,Customer customer) {
		customerDao.createAccount(account,customer);
	}

	@Override
	public Set<Account> getAccountList(Customer selectedCustomer) {
		Set<Account> accounts=selectedCustomer.getAccount();
		return accounts;
	}

	@Override
	public void createTransaction(Transaction transaction, Account account) {
		customerDao.createTransaction(transaction,account);
		
	}

	@Override
	public void debitAmount(Account selectedAccount,double amount) {
		selectedAccount.setBalance(selectedAccount.getBalance()-amount);
	}

	@Override
	public void creditAmount(Account selectedAccount,double amount) {
		selectedAccount.setBalance(selectedAccount.getBalance()+amount);
	}

	@Override
	public void TransferAmount(Account selectedAccount, Account selectedToAccount,double amount) {
		selectedAccount.setBalance(selectedAccount.getBalance()-amount);
		selectedToAccount.setBalance(selectedToAccount.getBalance()+amount);
	}
}
