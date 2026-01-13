import java.util.Scanner;
import java.util.regex.Pattern;

public class LicensePlateValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter license plate number: ");
        String licensePlate = scanner.nextLine();
        
        if (isValidLicensePlate(licensePlate)) {
            System.out.println("✅ Valid license plate");
        } else {
            System.out.println("❌ Invalid license plate");
        }
        
        scanner.close();
    }
    
    // Validate license plate: 2 uppercase letters + 4 digits
    public static boolean isValidLicensePlate(String licensePlate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return Pattern.matches(regex, licensePlate);
    }
}