// Payment Interface
interface PaymentMethod {
    boolean pay(double amount);
}

// UPI implementation
class UPIPayment implements PaymentMethod {
    private String upiId;
    
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount + " via " + upiId);
        return true; // Simulate successful payment
    }
}

// Credit Card implementation
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount + " via ****" + cardNumber.substring(cardNumber.length() - 4));
        return true; // Simulate successful payment
    }
}

// Wallet implementation
class WalletPayment implements PaymentMethod {
    private String walletName;
    private double balance;
    
    public WalletPayment(String walletName, double balance) {
        this.walletName = walletName;
        this.balance = balance;
    }
    
    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Processing " + walletName + " payment of ₹" + amount + ". Remaining balance: ₹" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance in " + walletName + ". Available: ₹" + balance);
            return false;
        }
    }
}

public class DigitalPaymentSystem {
    public static void main(String[] args) {
        PaymentMethod[] paymentMethods = {
            new UPIPayment("user@paytm"),
            new CreditCardPayment("1234567890123456"),
            new WalletPayment("PayTM Wallet", 500.0)
        };
        
        double amount = 250.0;
        
        for (PaymentMethod method : paymentMethods) {
            method.pay(amount);
            System.out.println();
        }
    }
}