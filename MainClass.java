package org.mno.mainClass;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.mno.model.Account;
import org.mno.model.Customer;
import org.mno.model.Transaction;
import org.mno.service.CustomerServiceImplementation;
import org.mno.service.ICustomerService;
import org.mno.view.UserInteraction;

import java.util.Iterator;

public class MainClass {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		UserInteraction userInteraction=new UserInteraction();
		ICustomerService customerService=new CustomerServiceImplementation();
		String opt = "n";
		do {
			
		
		System.out.println("Enter your option");
		System.out.println("1.create customer");
		System.out.println("2.List customers");
		System.out.println("3.Choose a customer <Enter valid customer Id>");
		
		int choice=scanner.nextInt();
		
		switch(choice) {
		
		case 1:
			
			Customer customer=userInteraction.getCustomerDetails();	
			//System.out.println(customer);
			customerService.createCustomer(customer);
			break;
		
		case 2:
			List<Customer> customers=customerService.getCustomersList();
			userInteraction.printCustomers(customers);
			break;
			
		case 3:
			Customer selectedCustomer=null;
			System.out.println("Enter customer ID");
			//selecting customer into selectedCustomer
			long tempCustomerId=scanner.nextLong();
			customers=customerService.getCustomersList();
			Iterator<Customer> customerIdMatching=customers.iterator();
			while(customerIdMatching.hasNext()) {
				Customer c=customerIdMatching.next();
				if(c.getCustomerId()==tempCustomerId) selectedCustomer=c;
			}
			
			do {
				//banking facilities for the selected customer
				System.out.println("Enter your option");
				System.out.println("1.Add account");
				System.out.println("2.Choose account for transactions");
				
				choice=scanner.nextInt();
				
				switch(choice) {	
					case 1:
						Account account=userInteraction.getAccountDetails();	
						customerService.createAccount(account,selectedCustomer);
						System.out.println("do u want to comtinue[y or n]");
						opt=scanner.next();
						break;
					case 2:
						
						System.out.println("Enter the account no.");
						
						Set<Account> accounts=customerService.getAccountList(selectedCustomer);
						userInteraction.printAccounts(accounts);
						
						Account selectedAccount=null;
						
						//selecting account into selectedAccount for transactions
						long tempAccountNo=scanner.nextLong();
						Iterator<Account> accountIdMatching=accounts.iterator();
						while(accountIdMatching.hasNext()) {
							Account a=accountIdMatching.next();
							if(a.getAccountNumber()==tempAccountNo) selectedAccount=a;
						}
						
						do {
							//transaction facilities for the selected customer
							System.out.println("Enter your option");
							System.out.println("1.Debit amount");
							System.out.println("2.Credit amount");
							System.out.println("3.Transfer funds");
							System.out.println("4. Transaction summary");

							choice=scanner.nextInt();
							
							switch(choice) {	
							case 1:
								Transaction transaction=userInteraction.getDebitDetails(selectedAccount);
								customerService.debitAmount(selectedAccount,transaction.getAmount());
								customerService.createTransaction(transaction, selectedAccount);
								break;
							case 2:
								transaction=userInteraction.getCreditDetails(selectedAccount);
								customerService.creditAmount(selectedAccount,transaction.getAmount());
								customerService.createTransaction(transaction, selectedAccount);
								break;
							case 3:
								//to Account transfer account
								Account selectedToAccount = null;
								tempAccountNo=scanner.nextLong();
								accountIdMatching=accounts.iterator();
								while(accountIdMatching.hasNext()) {
									Account a=accountIdMatching.next();
									if(a.getAccountNumber()==tempAccountNo) selectedToAccount=a;
								}		
								transaction=userInteraction.getTransferDetails(selectedAccount,selectedToAccount);
								customerService.TransferAmount(selectedAccount,selectedToAccount,transaction.getAmount());
								customerService.createTransaction(transaction, selectedAccount);
								break;
							case 4:
								//view transaction summary for a particular account
								System.out.println("Select account no.");
								Account selectedAccountForTransactionList = null;
								tempAccountNo=scanner.nextLong();
								accountIdMatching=accounts.iterator();
								while(accountIdMatching.hasNext()) {
									Account a=accountIdMatching.next();
									if(a.getAccountNumber()==tempAccountNo) selectedAccountForTransactionList=a;
								}
								userInteraction.printTransactions(selectedAccountForTransactionList.getTransaction());
							default:
								System.out.println("Enter 1/2/3");
							}
							System.out.println("do u want to make another transaction?[y|n]");
							opt=scanner.next();
						}while(opt.charAt(0)=='y');
						
						System.out.println("do u want to comtinue[y or n]");
						opt=scanner.next();
						break;
					default:
						System.out.println("Enter 1/2");
				}
			}while(opt.charAt(0)=='y');
			
			System.out.println("do u want to choose another account for transaction?[y|n]");
			opt=scanner.next();
			break;
			
		default:
			System.out.println("Enter 1/2/3");
		}
		
		System.out.println("do u want to view or do changes in an account?[y|n]");
		opt=scanner.next();
		}while(opt.charAt(0)=='y');
		
		
		scanner.close();
	}

}
