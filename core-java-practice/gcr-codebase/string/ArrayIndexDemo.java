import java.util.Scanner;

// Program to demonstrate array index out of bounds exception
public class ArrayIndexDemo {
    
    // Method that generates exception by accessing invalid index
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    // Method that handles array index exception
    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create array and get input
        String[] names = new String[3];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }
        
        // Test exception handling
        // generateException(names); // Uncomment to test exception
        handleException(names);
    }
}