// Payment interface for polymorphism
interface Payment {
    boolean processPayment(double amount) throws PaymentFailedException;
    String getPaymentMethod();
}

// Card payment implementation
class CardPayment implements Payment {
    private String cardNumber;
    
    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Simulate card payment processing
        if (cardNumber.length() < 16) {
            throw new PaymentFailedException("Invalid card number");
        }
        System.out.println("Processing card payment of $" + amount);
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Card Payment";
    }
}

// UPI payment implementation
class UPIPayment implements Payment {
    private String upiId;
    
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Simulate UPI payment processing
        if (!upiId.contains("@")) {
            throw new PaymentFailedException("Invalid UPI ID");
        }
        System.out.println("Processing UPI payment of $" + amount);
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "UPI Payment";
    }
}

// Wallet payment implementation
class WalletPayment implements Payment {
    private double walletBalance;
    
    public WalletPayment(double walletBalance) {
        this.walletBalance = walletBalance;
    }
    
    @Override
    public boolean processPayment(double amount) throws PaymentFailedException {
        // Check wallet balance
        if (walletBalance < amount) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        walletBalance -= amount;
        System.out.println("Processing wallet payment of $" + amount);
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Wallet Payment";
    }
}