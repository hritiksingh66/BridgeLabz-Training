import java.util.*;

// Abstract base class for bank accounts - demonstrates encapsulation
abstract class BankAccount{
	// Private fields - encapsulated data
	private int accountNumber; 
	private String holderName;
	private double balance;
	
	// Constructor to initialize account
	BankAccount(int accountNumber, String holderName, double balance){
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	// Setter method for account number
	void SetAN(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	// Getter method for account number
	int GetAN() {
		return accountNumber;
	}
	
	// Setter method for holder name
	void SetN(String holderName) {
		this.holderName = holderName;
	}
	
	// Getter method for holder name
	String GetN() {
		return holderName;
	}
	
	// Setter method for balance
	void SetB(double balance) {
		this.balance = balance;
	}
	
	// Getter method for balance
	double GetB() {
		return balance;
	}
	
	// Methods to be overridden by child classes
	void deposit(double amount) {}
	void withdraw(double amount){}
	
	// Abstract method - must be implemented by child classes
	abstract double calculateInterest(); 
}

// Interface for loan functionality
interface Loanable{
	void applyForLoan(int amount);
	String calculateLoanEligibility();
}

// Savings account class extends BankAccount and implements Loanable
class SavingsAccount extends BankAccount implements Loanable{
	double interestRate;
	String eligibility;
	
	// Constructor calls parent constructor
	SavingsAccount(int accountNumber, String holderName, double balance, double interestRate){
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
	}
	
	// Implementation of abstract method
	public double calculateInterest() {
		double interest = (GetB() * interestRate) / (365 * 100);
		return interest;
	}
	
	// Override deposit method
	void deposit(double amount) {
		double newBalance = GetB() + amount;
		SetB(newBalance);
		System.out.println("The Balance is: " + GetB());
	}
	
	// Override withdraw method
	void withdraw(double amount) {
		if(amount > GetB()) {
			System.out.println("Not Enough Balance");
		}
		else {
			double newBalance = GetB() - amount;
			SetB(newBalance);
			System.out.println("The Balance is: " + GetB());
		}
	}
	
	// Implementation of interface method
	public void applyForLoan(int amount) {
		if(amount >= GetB() * 0.5) {
			this.eligibility = "Eligible";
		}
		else {
			this.eligibility = "Not Eligible";
		}
	}
	
	// Implementation of interface method
	public String calculateLoanEligibility() {
		return eligibility;
	}
	
	// Method to display account details
	void Display() {
		System.out.println("Account Number: " + GetAN() + " | Account Holder Name: " + GetN() + " | Balance: " + GetB() + " | Interest: " + calculateInterest());
	}
}

// Current account class extends BankAccount and implements Loanable
class CurrentAccount extends BankAccount implements Loanable{
	double interestRate;
	String eligibility;
	
	// Constructor calls parent constructor
	CurrentAccount(int accountNumber, String holderName, double balance, double interestRate){
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
	}
	
	// Implementation of abstract method
	public double calculateInterest() {
		double interest = (GetB() * interestRate) / (365 * 100);
		return interest;
	}
	
	// Override deposit method
	void deposit(double amount) {
		double newBalance = GetB() + amount;
		SetB(newBalance);
		System.out.println("The Balance is: " + GetB());
	}
	
	// Override withdraw method
	void withdraw(double amount) {
		if(amount > GetB()) {
			System.out.println("Not Enough Balance");
		}
		else {
			double newBalance = GetB() - amount;
			SetB(newBalance);
			System.out.println("The Balance is: " + GetB());
		}
	}
	
	// Implementation of interface method
	public void applyForLoan(int amount) {
		if(amount <= GetB() * 0.5) {
			this.eligibility = "Eligible";
		}
		else {
			this.eligibility = "Not Eligible";
		}
	}
	
	// Implementation of interface method
	public String calculateLoanEligibility() {
		return eligibility;
	}
	
	// Method to display account details
	void Display() {
		System.out.println("Account Number: " + GetAN() + " | Account Holder Name: " + GetN() + " | Balance: " + GetB() + " | Interest: " + calculateInterest());
	}
}

// Main class to demonstrate banking system
public class BankingSystem {
	public static void main(String[] args) {
		// Create different account types
		CurrentAccount ca = new CurrentAccount(1001, "Alice", 50000.0, 1.5);
        SavingsAccount sa = new SavingsAccount(2001, "Bob", 100000.0, 3.5);
        
        // Demonstrate current account operations
        ca.Display();
        ca.withdraw(30000);
        ca.deposit(10000);
        ca.applyForLoan(15000);
        System.out.println("Current Account Loan Eligibility: " + ca.calculateLoanEligibility());
        
        // Demonstrate savings account operations
        sa.Display();
        sa.withdraw(30000);
        sa.deposit(20000);
        ca.applyForLoan(50000);
        System.out.println("Current Account Loan Eligibility: " + ca.calculateLoanEligibility());
	}
}