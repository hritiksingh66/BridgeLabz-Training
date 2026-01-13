import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to extract links from: ");
        String text = scanner.nextLine();
        
        extractLinks(text);
        
        scanner.close();
    }
    
    // Extract HTTP/HTTPS links from text
    public static void extractLinks(String text) {
        String regex = "https?://[\\w\\.-]+\\.[a-zA-Z]{2,}[/\\w\\.-]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted links:");
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
            System.out.println("No links found");
        }
    }
}