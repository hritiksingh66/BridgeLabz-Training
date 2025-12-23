// Program to compare two strings lexicographically
public class CompareStrings {
    
    // Compare two text strings and return comparison result
    public static int performStringComparison(String firstString, String secondString) {
        int shorterLength = Math.min(firstString.length(), secondString.length());
        
        // Compare character by character
        for (int position = 0; position < shorterLength; position++) {
            if (firstString.charAt(position) < secondString.charAt(position)) {
                return -1; // First string comes before second
            } else if (firstString.charAt(position) > secondString.charAt(position)) {
                return 1;  // First string comes after second
            }
        }
        
        // If all characters match, compare lengths
        return Integer.compare(firstString.length(), secondString.length());
    }
    
    public static void main(String[] args) {
        String textOne = "apple";
        String textTwo = "banana";
        
        int comparisonResult = performStringComparison(textOne, textTwo);
        
        System.out.println("String 1: " + textOne);
        System.out.println("String 2: " + textTwo);
        
        // Display comparison result
        if (comparisonResult < 0) {
            System.out.println("\"" + textOne + "\" comes before \"" + textTwo + "\" in lexicographical order");
        } else if (comparisonResult > 0) {
            System.out.println("\"" + textOne + "\" comes after \"" + textTwo + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}