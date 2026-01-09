import java.util.*;

public class UncheckedException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            // Perform division
            double result = num1 / num2;
            
            // Check for division by zero
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Cannot divide by zero!");
        } catch (InputMismatchException e) {
            // Handle invalid input
            System.out.println("Error: Please enter valid numbers!");
        } finally {
            scanner.close();
        }
    }
}