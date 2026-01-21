import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCSVData {
    
    // Email regex pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    // Phone regex pattern (exactly 10 digits)
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\d{10}$");
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        validateData(filePath);
        sc.close();
    }
    
    // Validate email and phone number columns
    public static void validateData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int rowNumber = 1;
            
            System.out.println("=== Validation Results ===");
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    rowNumber++;
                    continue;
                }
                
                String[] data = line.split(",");
                boolean hasError = false;
                
                // Validate email (assuming column 2)
                if (data.length > 2) {
                    String email = data[2].trim();
                    if (!EMAIL_PATTERN.matcher(email).matches()) {
                        System.out.println("Row " + rowNumber + " - Invalid email: " + email);
                        hasError = true;
                    }
                }
                
                // Validate phone (assuming column 3)
                if (data.length > 3) {
                    String phone = data[3].trim();
                    if (!PHONE_PATTERN.matcher(phone).matches()) {
                        System.out.println("Row " + rowNumber + " - Invalid phone: " + phone);
                        hasError = true;
                    }
                }
                
                if (!hasError) {
                    System.out.println("Row " + rowNumber + " - Valid");
                }
                
                rowNumber++;
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}