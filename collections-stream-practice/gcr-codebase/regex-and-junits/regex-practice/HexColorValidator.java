import java.util.Scanner;
import java.util.regex.Pattern;

public class HexColorValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter hex color code: ");
        String hexColor = scanner.nextLine();
        
        if (isValidHexColor(hexColor)) {
            System.out.println("✅ Valid hex color");
        } else {
            System.out.println("❌ Invalid hex color");
        }
        
        scanner.close();
    }
    
    // Validate hex color: # followed by 6 hex characters
    public static boolean isValidHexColor(String hexColor) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return Pattern.matches(regex, hexColor);
    }
}