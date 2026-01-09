import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Method that throws custom and standard exceptions
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        // Check for negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        
        // Check for insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        
        balance -= amount;
    }
}

public class BankTransactionSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            
            BankAccount account = new BankAccount(initialBalance);
            System.out.println("Account created with balance: " + account.getBalance());
            
            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = scanner.nextDouble();
            
            // Attempt withdrawal
            account.withdraw(withdrawAmount);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());
            
        } catch (InsufficientBalanceException e) {
            // Handle custom exception
            System.out.println("Insufficient balance!");
        } catch (IllegalArgumentException e) {
            // Handle invalid amount
            System.out.println("Invalid amount!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}