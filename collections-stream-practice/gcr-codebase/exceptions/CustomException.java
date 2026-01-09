import java.util.Scanner;

// Custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            validateAge(age);
            System.out.println("Access granted!");
            
        } catch (InvalidAgeException e) {
            System.out.println("Age must be 18 or above");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
    
    // Method that throws custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is below 18");
        }
    }
}