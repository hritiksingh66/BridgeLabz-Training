import java.util.Arrays;

// Program to check if two strings are anagrams of each other
public class AnagramCheck {
    
    // Check if two text strings are anagrams by sorting characters
    public static boolean checkIfAnagrams(String firstText, String secondText) {
        
        // Convert to lowercase and remove spaces
        firstText = firstText.toLowerCase().replaceAll("\\s", "");
        secondText = secondText.toLowerCase().replaceAll("\\s", "");
        
        // Different lengths cannot be anagrams
        if (firstText.length() != secondText.length()) {
            return false;
        }
        
        // Convert to character arrays
        char[] firstArray = firstText.toCharArray();
        char[] secondArray = secondText.toCharArray();
        
        // Sort both arrays
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        
        // Compare sorted arrays
        return Arrays.equals(firstArray, secondArray);
    }
    
    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silent";
        
        System.out.println("String 1: " + word1);
        System.out.println("String 2: " + word2);
        
        // Test anagram check
        if (checkIfAnagrams(word1, word2)) {
            System.out.println("The strings are anagrams of each other");
        } else {
            System.out.println("The strings are not anagrams");
        }
        
        // Test with another pair
        String word3 = "hello";
        String word4 = "world";
        System.out.println("\nString 3: " + word3);
        System.out.println("String 4: " + word4);
        System.out.println("Are anagrams: " + checkIfAnagrams(word3, word4));
    }
}