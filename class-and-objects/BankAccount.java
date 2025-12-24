// Bank account management system with deposit, withdraw and balance operations
public class BankAccount {
	// Account holder details
	private String accountHolder;
	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountHolder, String accountNumber, double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public static void displayBank() {
		System.out.println("\t\t\t\tState of Chennai\t\t\t\t");
	}
	
	// Add money to account with validation
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Amount to deposit must be positive");
		}
	}
	
	// Withdraw money with balance and amount validation
	public void withdraw(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			System.out.println("Withdraw amount is : " + amount);
		} else if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive");
		} else {
			System.out.println("Insufficient balance");
		}
	}
	
	public void displayBalance() {
		System.out.println("Current balance: " + balance);
	}
	
	public static void main(String[] args) {
		BankAccount account = new BankAccount("Lynda", "123456789", 700.00);
		
		displayBank();
		account.displayBalance();
		account.deposit(200.00);
		account.displayBalance();
		account.withdraw(100.00);
		account.displayBalance();
		account.withdraw(900.00);
	}
}