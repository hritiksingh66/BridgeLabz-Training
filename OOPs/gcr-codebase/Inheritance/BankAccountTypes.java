import java.util.*;

// Base class for all bank accounts
class BankAccount{
	int accountNumber;
	int balance;
	
	// Constructor to initialize account
	BankAccount(int accountNumber, int balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	// Method to display basic account info
	void Display() {
		System.out.print("Account Number: " + accountNumber + " Balance: " + balance);
	}
}

// Savings account inherits from BankAccount
class SavingsAccount extends BankAccount{
	double interestRate;
	
	// Constructor calls parent constructor using super()
	SavingsAccount(int accountNumber, int balance, double interestRate){
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	// Method to show account type
	void DisplayType() {
		System.out.println("Account Type: Savings Account");
	}
	
	// Override parent Display method to add interest rate
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" Interest Rate (%): " + interestRate);
	}
}

// Checking account inherits from BankAccount
class CheckingAccount extends BankAccount {
	int withdrawalLimit;
	
	// Constructor calls parent constructor
	CheckingAccount(int accountNumber, int balance, int withdrawalLimit){
		super(accountNumber, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	// Method to show account type
	void DisplayType() {
		System.out.println("Account Type: Checking Account");
	}
	
	// Override Display to add withdrawal limit
	void Display() {
		super.Display();
		System.out.print(" Withdrawal Limit: " + withdrawalLimit);
	}
}

// Fixed deposit account inherits from BankAccount
class FixedDepositAccount extends BankAccount{
	
	// Constructor calls parent constructor
	FixedDepositAccount(int accountNumber, int balance){
		super(accountNumber, balance);
	}
	
	// Method to show account type
	void DisplayType() {
		System.out.println("Account Type: Fixed Deposit Account");
	}
	
	// Uses parent Display method as-is
	void Display() {
		super.Display();
	}
}

// Main class to demonstrate inheritance
public class BankAccountTypes {
	public static void main(String[] args) {
		// Create different types of accounts
		SavingsAccount s1 = new SavingsAccount(684115325, 12000, 10.5);
		CheckingAccount c1 = new CheckingAccount(484522532, 20000, 10000);
		FixedDepositAccount f1 = new FixedDepositAccount(789521532, 25000);
		
		// Display account information
		s1.DisplayType();
		s1.Display();
		System.out.println();
		
		c1.DisplayType();
		c1.Display();
		System.out.println();
		
		f1.DisplayType();
		f1.Display();
		System.out.println();
	}
}
