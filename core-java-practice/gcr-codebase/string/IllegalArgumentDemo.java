import java.util.*;

// Program to demonstrate IllegalArgumentException handling
public class IllegalArgumentDemo {
    
    // Method that generates exception with invalid substring parameters
    public static void generateException(String s) {
        System.out.println(s.substring(5, 2)); // Invalid: start > end
    }

    // Method that handles IllegalArgumentException
    public static void handleException(String s) {
        try {
            System.out.println(s.substring(5, 2)); // Invalid: start > end
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input string from user
        String s = sc.next();
        
        // Test exception handling
        handleException(s);
    }
}
