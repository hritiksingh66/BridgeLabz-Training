package reviews.reviews1;
import java.time.LocalDateTime;
import java.util.LinkedList;

abstract class Account implements BankService {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected LinkedList<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new LinkedList<>();
        addTransaction("DEPOSIT", initialBalance, "Initial deposit");
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        addTransaction("DEPOSIT", amount, "Deposit");
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
        addTransaction("WITHDRAWAL", amount, "Withdrawal");
    }

    private void addTransaction(String type, double amount, String description) {
        transactionHistory.add(new Transaction(type, amount, description, LocalDateTime.now()));
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String name) { this.accountHolderName = name; }
    public LinkedList<Transaction> getTransactionHistory() { return transactionHistory; }
}