import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Shared bank account class with synchronization
class BankAccountSynchronized {
    private double balance;

    public BankAccountSynchronized(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized withdraw method - prevents race conditions
    public synchronized boolean withdraw(String customerName, double amount) {
        System.out.println("[" + customerName + "] Attempting to withdraw " + (int)amount);
        
        // Check if sufficient balance exists
        if (balance >= amount) {
            try {
                // Simulate processing delay
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Deduct amount from balance
            balance -= amount;
            
            // Get timestamp
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            
            System.out.println("Transaction successful: " + customerName + ", Amount: " + (int)amount + 
                             ", Balance: " + (int)balance + ", Time: " + timestamp);
            return true;
        } else {
            System.out.println("Transaction failed: " + customerName + ", Amount: " + (int)amount + 
                             ", Insufficient balance: " + (int)balance);
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Transaction class implementing Runnable
class TransactionSynchronized implements Runnable {
    private BankAccountSynchronized account;
    private String customerName;
    private double amount;

    public TransactionSynchronized(BankAccountSynchronized account, String customerName, double amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Display thread state before processing
        System.out.println("[" + customerName + "] Thread state: " + Thread.currentThread().getState());
        
        // Process withdrawal
        account.withdraw(customerName, amount);
    }
}

public class ATMTransactionSystemSynchronized {
    public static void main(String[] args) {
        // Create shared bank account with initial balance of 10,000
        BankAccountSynchronized account = new BankAccountSynchronized(10000);
        
        System.out.println("Initial Balance: " + (int)account.getBalance());
        System.out.println("Starting ATM transactions (Synchronized)...\n");

        // Create 5 transaction threads with different amounts
        Thread t1 = new Thread(new TransactionSynchronized(account, "Customer-1", 3000), "Customer-1");
        Thread t2 = new Thread(new TransactionSynchronized(account, "Customer-2", 4000), "Customer-2");
        Thread t3 = new Thread(new TransactionSynchronized(account, "Customer-3", 2000), "Customer-3");
        Thread t4 = new Thread(new TransactionSynchronized(account, "Customer-4", 5000), "Customer-4");
        Thread t5 = new Thread(new TransactionSynchronized(account, "Customer-5", 1500), "Customer-5");

        // Start all transaction threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            // Wait for all transactions to complete
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll transactions completed!");
        System.out.println("Final Balance: " + (int)account.getBalance());
    }
}
