package reviews.reviews1;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDateTime;

public class OnlineBankingSystem {
    private static final Map<String, Account> accounts = new ConcurrentHashMap<>();
    private static int accountCounter = 1000;

    // CRUD Operations
    public static String createAccount(String name, String type, double initialDeposit) {
        String accountNumber = "ACC" + (++accountCounter);
        Account account = type.equalsIgnoreCase("savings") 
            ? new SavingsAccount(accountNumber, name, initialDeposit)
            : new CurrentAccount(accountNumber, name, initialDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }


    public static Account readAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public static boolean updateAccount(String accountNumber, String newName) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setAccountHolderName(newName);
            return true;
        }
        return false;
    }

    public static boolean deleteAccount(String accountNumber) {
        return accounts.remove(accountNumber) != null;
    }

    public static synchronized void fundTransfer(String fromAccount, String toAccount, double amount) {
        Account from = accounts.get(fromAccount);
        Account to = accounts.get(toAccount);
        
        if (from != null && to != null) {
            try {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transfer successful: " + amount + " from " + fromAccount + " to " + toAccount);
            } catch (InsufficientBalanceException e) {
                System.out.println("Transfer failed: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid account number(s)");
        }
    }

    public static double balanceCheck(String accountNumber) {
        Account account = accounts.get(accountNumber);
        return account != null ? account.getBalance() : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Online Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Fund Transfer");
            System.out.println("6. Check Balance");
            System.out.println("7. View All Accounts");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter account type (savings/current): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double deposit = scanner.nextDouble();
                    String accNum = createAccount(name, type, deposit);
                    System.out.println("Account created: " + accNum);
                    break;
                    
                case 2:
                    System.out.print("Enter account number: ");
                    String viewAcc = scanner.nextLine();
                    Account account = readAccount(viewAcc);
                    if (account != null) {
                        System.out.println("Account: " + account.getAccountNumber());
                        System.out.println("Name: " + account.getAccountHolderName());
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter account number: ");
                    String updateAcc = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    if (updateAccount(updateAcc, newName)) {
                        System.out.println("Account updated successfully");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter account number: ");
                    String deleteAcc = scanner.nextLine();
                    if (deleteAccount(deleteAcc)) {
                        System.out.println("Account deleted successfully");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                    
                case 5:
                    System.out.print("From account: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("To account: ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    fundTransfer(fromAcc, toAcc, amount);
                    break;
                    
                case 6:
                    System.out.print("Enter account number: ");
                    String balAcc = scanner.nextLine();
                    double balance = balanceCheck(balAcc);
                    if (balance >= 0) {
                        System.out.println("Balance: " + balance);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                    
                case 7:
                    System.out.println("\nAll Accounts:");
                    accounts.forEach((accNo, acc) -> 
                        System.out.println(accNo + " - " + acc.getAccountHolderName() + " (Balance: " + acc.getBalance() + ")"));
                    break;
                    
                case 8:
                    System.out.println("Thank you for using Online Banking System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}