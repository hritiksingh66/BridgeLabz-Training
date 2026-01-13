import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSNValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text containing SSN: ");
        String text = scanner.nextLine();
        
        validateSSN(text);
        
        scanner.close();
    }
    
    // Validate Social Security Number (XXX-XX-XXXX format)
    public static void validateSSN(String text) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        boolean found = false;
        while (matcher.find()) {
            String ssn = matcher.group();
            System.out.println("✅ \"" + ssn + "\" is valid SSN format");
            found = true;
        }
        
        if (!found) {
            System.out.println("❌ No valid SSN format found");
        }
    }
}