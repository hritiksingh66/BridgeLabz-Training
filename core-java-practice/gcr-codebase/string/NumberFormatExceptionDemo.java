import java.util.*;

// Program to demonstrate NumberFormatException handling
public class NumberFormatExceptionDemo {
    
    // Method that generates NumberFormatException
    public static void generateException(String text) {
        int num = Integer.parseInt(text); // Parse invalid string to integer
        System.out.println(num);
    }

    // Method that handles NumberFormatException
    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text); // Parse invalid string to integer
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input string from user
        String text = sc.next();
        
        // Test exception handling
        handleException(text);
    }
}
