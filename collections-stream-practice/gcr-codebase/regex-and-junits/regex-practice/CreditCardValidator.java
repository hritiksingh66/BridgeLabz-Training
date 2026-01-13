import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();
        
        String cardType = validateCreditCard(cardNumber);
        
        if (cardType != null) {
            System.out.println("✅ Valid " + cardType + " card");
        } else {
            System.out.println("❌ Invalid credit card number");
        }
        
        scanner.close();
    }
    
    // Validate credit card (Visa starts with 4, MasterCard starts with 5, both 16 digits)
    public static String validateCreditCard(String cardNumber) {
        // Remove spaces and dashes
        cardNumber = cardNumber.replaceAll("[\\s-]", "");
        
        // Visa: starts with 4, 16 digits
        if (Pattern.matches("^4\\d{15}$", cardNumber)) {
            return "Visa";
        }
        
        // MasterCard: starts with 5, 16 digits
        if (Pattern.matches("^5\\d{15}$", cardNumber)) {
            return "MasterCard";
        }
        
        return null;
    }
}