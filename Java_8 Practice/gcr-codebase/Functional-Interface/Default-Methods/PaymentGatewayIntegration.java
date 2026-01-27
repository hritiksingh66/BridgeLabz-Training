// Payment processor interface with default methods
interface PaymentProcessor {
    boolean processPayment(double amount);
    
    // Default refund method - added without breaking existing implementations
    default boolean refund(double amount) {
        System.out.println("Processing refund of ₹" + amount + " using default refund mechanism");
        return true; // Default implementation
    }
    
    // Default method for transaction history
    default void logTransaction(String type, double amount) {
        System.out.println("Transaction logged: " + type + " - ₹" + amount);
    }
}

// Old payment provider (doesn't implement refund)
class PayPalProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("PayPal: Processing payment of ₹" + amount);
        logTransaction("PAYMENT", amount);
        return true;
    }
}

// New payment provider (implements custom refund)
class StripeProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Stripe: Processing payment of ₹" + amount);
        logTransaction("PAYMENT", amount);
        return true;
    }
    
    @Override
    public boolean refund(double amount) {
        System.out.println("Stripe: Processing custom refund of ₹" + amount + " with instant processing");
        logTransaction("REFUND", amount);
        return true;
    }
}

// Another old provider
class RazorpayProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Razorpay: Processing payment of ₹" + amount);
        logTransaction("PAYMENT", amount);
        return true;
    }
}

public class PaymentGatewayIntegration {
    
    public static void processTransaction(PaymentProcessor processor, double amount) {
        // Process payment
        processor.processPayment(amount);
        
        // Process refund (uses default or custom implementation)
        processor.refund(amount * 0.5); // Partial refund
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        PaymentProcessor[] processors = {
            new PayPalProcessor(),      // Uses default refund
            new StripeProcessor(),      // Uses custom refund
            new RazorpayProcessor()     // Uses default refund
        };
        
        double amount = 1000.0;
        
        for (PaymentProcessor processor : processors) {
            processTransaction(processor, amount);
        }
    }
}