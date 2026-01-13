import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWordsFinder {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter sentence to find repeating words: ");
        String sentence = scanner.nextLine();
        
        findRepeatingWords(sentence);
        
        scanner.close();
    }
    
    // Find repeating consecutive words
    public static void findRepeatingWords(String sentence) {
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);
        
        System.out.println("Repeating words found:");
        boolean found = false;
        while (matcher.find()) {
            if (found) System.out.print(", ");
            System.out.print(matcher.group(1));
            found = true;
        }
        
        if (found) {
            System.out.println();
        } else {
            System.out.println("No repeating words found");
        }
    }
}