import java.util.Scanner;

public class BadWordsCensor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter sentence to censor: ");
        String sentence = scanner.nextLine();
        
        String censored = censorBadWords(sentence);
        
        System.out.println("Original: " + sentence);
        System.out.println("Censored: " + censored);
        
        scanner.close();
    }
    
    // Censor bad words with ****
    public static String censorBadWords(String sentence) {
        String[] badWords = {"damn", "stupid", "hell", "crap"};
        String result = sentence;
        
        for (String badWord : badWords) {
            // Case insensitive replacement
            result = result.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }
        
        return result;
    }
}