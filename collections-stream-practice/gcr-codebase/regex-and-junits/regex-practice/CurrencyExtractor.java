import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyExtractor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to extract currency values: ");
        String text = scanner.nextLine();
        
        extractCurrencyValues(text);
        
        scanner.close();
    }
    
    // Extract currency values from text
    public static void extractCurrencyValues(String text) {
        String regex = "\\$?\\d+\\.\\d{2}|\\$\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Currency values found:");
        boolean found = false;
        while (matcher.find()) {
            if (found) System.out.print(", ");
            System.out.print(matcher.group());
            found = true;
        }
        
        if (found) {
            System.out.println();
        } else {
            System.out.println("No currency values found");
        }
    }
}