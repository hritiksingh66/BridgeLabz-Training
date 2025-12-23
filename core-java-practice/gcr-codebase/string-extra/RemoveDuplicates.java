import java.util.LinkedHashSet;

// Program to remove duplicate characters from a string
public class RemoveDuplicates {
    
    // Remove duplicate characters while preserving order
    public static String eliminateDuplicateChars(String inputText) {
        LinkedHashSet<Character> uniqueCharSet = new LinkedHashSet<>();
        
        // Add each character to set (automatically removes duplicates)
        for (char character : inputText.toCharArray()) {
            uniqueCharSet.add(character);
        }
        
        StringBuilder finalResult = new StringBuilder();
        // Build result string from unique characters
        for (char character : uniqueCharSet) {
            finalResult.append(character);
        }
        
        return finalResult.toString();
    }
    
    public static void main(String[] args) {
        String originalString = "programming";
        String processedResult = eliminateDuplicateChars(originalString);
        
        System.out.println("Original: " + originalString);
        System.out.println("After removing duplicates: " + processedResult);
    }
}