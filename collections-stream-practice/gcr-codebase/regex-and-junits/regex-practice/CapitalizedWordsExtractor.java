import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordsExtractor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter sentence to extract capitalized words: ");
        String sentence = scanner.nextLine();
        
        extractCapitalizedWords(sentence);
        
        scanner.close();
    }
    
    // Extract all capitalized words from sentence
    public static void extractCapitalizedWords(String sentence) {
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        
        System.out.println("Capitalized words:");
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
            System.out.println("No capitalized words found");
        }
    }
}