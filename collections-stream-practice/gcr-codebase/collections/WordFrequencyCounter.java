import java.util.*;

public class WordFrequencyCounter {
    
    // Count word frequency, ignore case and punctuation
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        // Remove punctuation and convert to lowercase
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
    
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> frequency = countWords(text);
        
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Word frequency: " + frequency);
    }
}