import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to extract dates from: ");
        String text = scanner.nextLine();
        
        extractDates(text);
        
        scanner.close();
    }
    
    // Extract dates in dd/mm/yyyy format
    public static void extractDates(String text) {
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted dates:");
        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group());
            found = true;
            if (matcher.find()) {
                System.out.print(", " + matcher.group());
            }
        }
        
        if (found) {
            System.out.println();
        } else {
            System.out.println("No dates found");
        }
    }
}