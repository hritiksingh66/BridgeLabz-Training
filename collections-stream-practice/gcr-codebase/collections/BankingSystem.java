import java.util.*;

public class BankingSystem {
    private HashMap<String, Double> accounts;
    private TreeMap<Double, String> accountsByBalance;
    private Queue<String> withdrawalRequests;
    
    public BankingSystem() {
        accounts = new HashMap<>();
        accountsByBalance = new TreeMap<>(Collections.reverseOrder());
        withdrawalRequests = new LinkedList<>();
    }
    
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        accountsByBalance.put(initialBalance, accountNumber);
        System.out.println("Account " + accountNumber + " created with balance: $" + initialBalance);
    }
    
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            
            accountsByBalance.remove(oldBalance);
            accountsByBalance.put(newBalance, accountNumber);
            
            System.out.println("Deposited $" + amount + " to " + accountNumber);
        }
    }
    
    public void requestWithdrawal(String accountNumber) {
        withdrawalRequests.offer(accountNumber);
        System.out.println("Withdrawal request added for " + accountNumber);
    }
    
    public void processWithdrawals() {
        System.out.println("Processing withdrawal requests:");
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            System.out.println("Processing withdrawal for: " + accountNumber + 
                             " (Balance: $" + accounts.get(accountNumber) + ")");
        }
    }
    
    public void displayAccountsByBalance() {
        System.out.println("Accounts sorted by balance (highest first):");
        for (Map.Entry<Double, String> entry : accountsByBalance.entrySet()) {
            System.out.println(entry.getValue() + ": $" + entry.getKey());
        }
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        bank.createAccount("ACC001", 5000.0);
        bank.createAccount("ACC002", 2500.0);
        bank.createAccount("ACC003", 7500.0);
        
        bank.deposit("ACC002", 1000.0);
        
        bank.requestWithdrawal("ACC001");
        bank.requestWithdrawal("ACC003");
        
        bank.displayAccountsByBalance();
        bank.processWithdrawals();
    }
}