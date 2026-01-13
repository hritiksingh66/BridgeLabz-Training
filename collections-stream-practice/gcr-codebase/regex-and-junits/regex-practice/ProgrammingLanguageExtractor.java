import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageExtractor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to extract programming languages: ");
        String text = scanner.nextLine();
        
        extractProgrammingLanguages(text);
        
        scanner.close();
    }
    
    // Extract programming language names from text
    public static void extractProgrammingLanguages(String text) {
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C\\+\\+", "C#", "Ruby", "PHP", "Swift", "Kotlin"};
        
        System.out.println("Programming languages found:");
        boolean found = false;
        
        for (String language : languages) {
            Pattern pattern = Pattern.compile("\\b" + language + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            
            if (matcher.find()) {
                if (found) System.out.print(", ");
                System.out.print(matcher.group());
                found = true;
            }
        }
        
        if (found) {
            System.out.println();
        } else {
            System.out.println("No programming languages found");
        }
    }
}