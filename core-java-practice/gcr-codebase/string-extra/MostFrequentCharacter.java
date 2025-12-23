import java.util.HashMap;
import java.util.Map;

// Program to find the most frequently occurring character in a string
public class MostFrequentCharacter {
    
    // Find character that appears most frequently in text
    public static char locateMostFrequentChar(String inputText) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        
        // Count frequency of each character
        for (char letter : inputText.toCharArray()) {
            characterFrequency.put(letter, characterFrequency.getOrDefault(letter, 0) + 1);
        }
        
        char highestFreqChar = inputText.charAt(0);
        int maximumCount = 0;
        
        // Find character with highest frequency
        for (Map.Entry<Character, Integer> mapEntry : characterFrequency.entrySet()) {
            if (mapEntry.getValue() > maximumCount) {
                maximumCount = mapEntry.getValue();
                highestFreqChar = mapEntry.getKey();
            }
        }
        
        return highestFreqChar;
    }
    
    public static void main(String[] args) {
        String testInput = "success";
        char topFrequentChar = locateMostFrequentChar(testInput);
        
        System.out.println("String: " + testInput);
        System.out.println("Most Frequent Character: " + topFrequentChar);
    }
}