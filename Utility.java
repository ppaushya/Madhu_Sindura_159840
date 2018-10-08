package org.mno.util;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mno.model.AccountType;
import org.mno.model.Address;

public class Utility {
	
	private static int accNumber=200000;
	private static Scanner scanner=new Scanner(System.in);
	private static String tempFirstName;
	private static String tempLastName;
	private static String tempMail;
	private static String tempMobileNo;
	private static LocalDate tempDoB;
	private static String tempDateStr;
	
	public static long generateNumber() {
		return accNumber++;
	}

	public static String promptFirstName() {
		System.out.print("Enter first name: ");
		while(true) {
			tempFirstName=scanner.next();
			Pattern p=Pattern.compile("[a-zA-Z]{3,}");
			Matcher match=p.matcher(tempFirstName);
			if(!match.find()) System.out.println("Enter valid first name");
			else break;
		}
		return tempFirstName;
	}

	public static String promptLastName() {
		System.out.print("Enter last name: ");
		while(true) {
			tempLastName=scanner.next();
			Pattern p=Pattern.compile("[a-zA-Z]{3,}");
			Matcher match=p.matcher(tempLastName);
			if(!match.find()) System.out.println("Enter valid last name");
			else break;
		}
		return tempLastName;
	}

	public static String promptEmailId() {
		System.out.print("Enter mail Id: ");
		while(true) {
			tempMail=scanner.next();
			Pattern p=Pattern.compile("[a-z]+@[a-z]+.(com|in)");
			Matcher match=p.matcher(tempMail);
			if(!match.find()) System.out.println("Enter valid mail id");
			else break;
		}
		return tempMail;
	}

	public static String promptMobileNo() {
		System.out.print("Enter mobile no.: ");
		while(true) {
			tempMobileNo=scanner.next();
			Pattern p=Pattern.compile("[789][0-9]{9}");
			Matcher match=p.matcher(tempMobileNo);
			if(!match.find()) System.out.println("Enter valid mobile no.");
			else break;
		}
		return tempMobileNo;
	}

	public static LocalDate promptDate() {
		System.out.print("Enter date of birth in dd/mm/yyyy format: ");
		while(true) {
			tempDateStr = scanner.next();
			Pattern p=Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
			Matcher match=p.matcher(tempDateStr);
			if(!match.find()) System.out.println("Please follow the provided format");
			else break;
		}
		String[] str=tempDateStr.split("/", 3);
		tempDoB=LocalDate.of(Integer.parseInt(str[2]), Integer.parseInt(str[1]), Integer.parseInt(str[0]));
		return tempDoB;
	}
	
	private static String tempAddressLine1;
	private static String tempAddressLine2;
	private static String tempCity;
	private static String tempState;
	private static String tempPinCode;
	private static Address tempAddress;
	
	public static Address promptAddress() {
		tempAddressLine1=promptAddress1();
		tempAddressLine2=promptAddressLine2();
		tempCity=promptCity();
		tempState=promptState();
		tempPinCode=promptPinCode();
		tempAddress=new Address(tempAddressLine1, tempAddressLine2, tempCity, tempState, tempPinCode);
		return tempAddress;
	}

	private static String promptAddress1() {
		System.out.print("Enter Address Line 1: ");
		while(true) {
			tempAddressLine1 = scanner.next();
			Pattern p=Pattern.compile("[a-z]{3,}");
			Matcher match=p.matcher(tempAddressLine1);
			if(!match.find()) System.out.println("Please enter valid address");
			else break;
		}
		return tempAddressLine1;
	}

	private static String promptAddressLine2() {
		System.out.print("Enter Address Line 2: ");
		while(true) {
			tempAddressLine2 = scanner.next();
			Pattern p=Pattern.compile("[a-z]{3,}");
			Matcher match=p.matcher(tempAddressLine2);
			if(!match.find()) System.out.println("Please enter valid address");
			else break;
		}
		return tempAddressLine2;
	}

	private static String promptCity() {
		System.out.print("Enter city: ");
		while(true) {
			tempCity = scanner.next();
			Pattern p=Pattern.compile("[a-z]{3,}");
			Matcher match=p.matcher(tempCity);
			if(!match.find()) System.out.println("Please enter valid city");
			else break;
		}
		return tempCity;
	}

	private static String promptState() {
		System.out.print("Enter state: ");
		while(true) {
			tempState = scanner.next();
			Pattern p=Pattern.compile("[a-z]{3,}");
			Matcher match=p.matcher(tempState);
			if(!match.find()) System.out.println("Please enter valid state");
			else break;
		}
		return tempState;
	}

	private static String promptPinCode() {
		System.out.print("Enter pin code: ");
		while(true) {
			tempPinCode = scanner.next();
			Pattern p=Pattern.compile("[0-9]{6}");
			Matcher match=p.matcher(tempPinCode);
			if(!match.find()) System.out.println("Please enter pin code");
			else break;
		}
		return tempPinCode;
	}

	private static long accountNumber=100000;
	private static AccountType tempAccountType;
	private static double tempOpeningBalance;
	private static int accoutCreatedCount=1;
	
	
	public static long generateAccountNumber() {
		return accountNumber++;
	}

	public static AccountType promptAccountType() {
		System.out.print("Enter Account type: ");
		String temp=scanner.next();
		tempAccountType = AccountType.valueOf(temp);
		return tempAccountType;
	}

	public static double promptOpeningBalance() {
		System.out.print("Enter opening balance: ");
		tempOpeningBalance = scanner.nextDouble();
		return tempOpeningBalance;
	}

	public static LocalDate getOpeningdate() {
		return LocalDate.now();
	}

	public static String promptDescription() {
		return "Account no. "+(accoutCreatedCount++)+ "created in this session!";
	}

	private static int tempTransactionId=1;
	private static double tempAmount;

	public static double generateTransactionID() {
		return tempTransactionId++;
	}

	public static LocalDate promptTrasnactionDate() {
		return LocalDate.now();
	}

	public static double promptAmount() {
		tempAmount=scanner.nextDouble();
		return tempAmount;
	}

	public static String getDebitDescription() {
		return tempTransactionId+" transactions done yet! <debit>";
	}
	
	public static String getCreditDescription() {
		return tempTransactionId+" transactions done yet! <credits>";
	}

	public static String getTransferDescription() {
		return tempTransactionId+" transactions done yet! <transfer>";
	}

}
