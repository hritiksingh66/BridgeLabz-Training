// Program to count occurrences of a substring in a string
public class SubstringOccurrences {
    
    // Count how many times target substring appears in main text
    public static int calculateOccurrenceCount(String mainText, String targetSubstring) {
        int occurrenceCount = 0;
        int searchIndex = 0;
        
        // Search for substring starting from each position
        while ((searchIndex = mainText.indexOf(targetSubstring, searchIndex)) != -1) {
            occurrenceCount++;
            searchIndex += targetSubstring.length();
        }
        
        return occurrenceCount;
    }
    
    public static void main(String[] args) {
        String sourceText = "hello world hello universe hello";
        String searchPattern = "hello";
        
        int totalOccurrences = calculateOccurrenceCount(sourceText, searchPattern);
        
        System.out.println("String: " + sourceText);
        System.out.println("Substring: " + searchPattern);
        System.out.println("Occurrences: " + totalOccurrences);
    }
}