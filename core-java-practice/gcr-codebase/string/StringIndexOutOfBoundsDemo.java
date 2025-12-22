import java.util.*;

// Program to demonstrate StringIndexOutOfBoundsException handling
public class StringIndexOutOfBoundsDemo {
    
    // Method that generates StringIndexOutOfBoundsException
    public static void generateException(String s) {
        System.out.println(s.charAt(s.length())); // Invalid index: length is out of bounds
    }

    // Method that handles StringIndexOutOfBoundsException
    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length())); // Invalid index: length is out of bounds
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
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
