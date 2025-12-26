import java.util.*;

// BankAccount class demonstrating static, final, and this keywords
class BankAccount{
	// static variable - shared across all BankAccount instances
	static String bName;
	
	// Instance variables - unique to each BankAccount object
	String aName;
	
	// final variable - cannot be changed once initialized
	final int accNum;
	
	// static counter to track total accounts created
	static int tc = 0;
	
	// Constructor to initialize BankAccount object
	BankAccount(String aName, int accNum){
		// 'this' keyword refers to current object instance
		this.bName = "HDFC Bank";  // Setting static variable (not recommended)
		this.aName = aName;        // Distinguishes parameter from instance variable
		this.accNum = accNum;      // final variable can only be assigned once
		tc++;                      // Increment static counter
	}
	
	// Method to display account information
	void Display() {
		System.out.println("Bank Name: " + bName + " | Account Holder Name: " + aName + " | Account Number: " + accNum);
	}
	
	// static method to display total count - can only access static variables
	static void TC() {
		System.out.println("The Total Accounts created are: " + tc);
	}
}
// Main class demonstrating bank account system
public class BankAccountSystem {
	public static void main(String[] args) {
		// Creating BankAccount objects - each has unique instance variables but shares static variables
		BankAccount b1 = new BankAccount("John", 680654279);
		BankAccount b2 = new BankAccount("Alice", 450126789);
		BankAccount b3 = new BankAccount("Robert", 902345671);
		BankAccount b4 = new BankAccount("Emily", 781245987);
		BankAccount b5 = new BankAccount("David", 367891234);
		
		// Creating a String object to test instanceof operator
		Object b6 = new String("Hello");
		
		// Using instanceof operator to check object type before method calls
		if(b1 instanceof BankAccount) {
			System.out.println("Instance of Bank Account");
			System.out.println("Account Details");
			b1.Display();
		}
		
		// Displaying account details for all valid BankAccount objects
		System.out.println("Account Details");
		b2.Display();
		
		System.out.println("Account Details");
		b3.Display();

		System.out.println("Account Details");
		b4.Display();
		
		System.out.println("Account Details");
		b5.Display();
		
		// Testing with non-BankAccount object
		if(b6 instanceof BankAccount) {
			System.out.println("Instance of Bank Account");
		}
		else {
			System.out.println("Not An Instance of Bank Account");
		}
		
		// Calling static method using class name (recommended approach)
		BankAccount.TC();
	}
}
