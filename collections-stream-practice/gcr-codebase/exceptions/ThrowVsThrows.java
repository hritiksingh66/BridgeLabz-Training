import java.util.Scanner;

public class ThrowVsThrows {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter principal amount: ");
            double amount = scanner.nextDouble();
            
            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();
            
            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();
            
            // Call method that throws exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    // Method that throws exception using 'throws' keyword
    public static double calculateInterest(double amount, double rate, int years) 
            throws IllegalArgumentException {
        
        // Throw exception if invalid input
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Negative values not allowed");
        }
        
        return (amount * rate * years) / 100;
    }
}