import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter IP address to validate: ");
        String ipAddress = scanner.nextLine();
        
        if (isValidIPAddress(ipAddress)) {
            System.out.println("✅ Valid IP address");
        } else {
            System.out.println("❌ Invalid IP address");
        }
        
        scanner.close();
    }
    
    // Validate IPv4 address (0-255 for each octet)
    public static boolean isValidIPAddress(String ipAddress) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(regex, ipAddress);
    }
}