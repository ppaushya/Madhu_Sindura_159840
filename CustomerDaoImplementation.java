package org.mno.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.mno.model.Account;
import org.mno.model.Address;
import org.mno.model.Customer;
import org.mno.model.Transaction;

public class CustomerDaoImplementation implements ICustomerDao{
private static List<Customer> customers=dummy();

	private static List<Customer> dummy(){
		
		List<Customer> customers=new ArrayList<>();
		Address address;
			
		address=new Address("23,west Car St", "2nd St", "Chennai", "TN", "234442");
		customers.add(new Customer(123,"Jack","Thomson", "jack@gmail.com","8890912345",LocalDate.of(1991, 01, 23),
				address,new HashSet<Account>()));
		
		address=new Address("North Avnnue", "2nd Cross St", "Hyderabad", "AP", "657657");
		customers.add(new Customer(1090,"Tom","Jerry","tom@gmail.com","9090912345", LocalDate.of(1987, 12, 23),
				address,new HashSet<Account>()));
		
		return customers;
	}
	
	
	@Override
	public List<Customer> getCustomersList() {

		return customers;
		
	}

	@Override
	public void createCustomer(Customer customer) {
		
		customers.add(customer);
		System.out.println("customer123");	
	}


	@Override
	public void createAccount(Account account, Customer customer) {
		
		customer.getAccount().add(account);
		System.out.println("account123");
	}


	@Override
	public void createTransaction(Transaction transaction,Account account) {
		
		account.getTransaction().add(transaction);
		System.out.println("transaction123");
	}
	
}
