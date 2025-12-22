import java.util.Scanner;

// Program to convert string to uppercase manually vs built-in method
public class UppercaseDemo {
    
    // Convert string to uppercase manually
    public static String toUpper(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Convert lowercase to uppercase by subtracting 32 from ASCII value
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Compare two strings character by character
    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input string from user
        String text = scanner.nextLine();
        
        // Compare manual and built-in methods
        String manual = toUpper(text);
        String builtin = text.toUpperCase();
        
        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
        System.out.println("Are equal: " + compareStrings(manual, builtin));
    }
}