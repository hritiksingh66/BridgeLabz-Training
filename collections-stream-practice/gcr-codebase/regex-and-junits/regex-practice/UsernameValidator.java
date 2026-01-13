import java.util.Scanner;
import java.util.regex.Pattern;

public class UsernameValidator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter username to validate: ");
        String username = sc.nextLine();
        
        if (isValidUsername(username)) {
            System.out.println("✅ Valid username");
        } else {
            System.out.println("❌ Invalid username");
        }
        
        sc.close();
    }
    
    // Validate username: starts with letter, 5-15 chars, letters/numbers/underscore only
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return Pattern.matches(regex, username);
    }
}