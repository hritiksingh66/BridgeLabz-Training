// Program to trim string manually and compare with built-in trim method
public class StringTrim {

    // Find start and end indices for trimming spaces
    public static int[] findTrimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;
        
        // Find first non-space character from start
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        
        // Find first non-space character from end
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end + 1};
    }

    // Create substring manually
    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test string with leading and trailing spaces
        String input = "   Hello World!   ";
        
        // Trim using manual method
        int[] indices = findTrimIndices(input);
        String trimmed = createSubstring(input, indices[0], indices[1]);
        
        // Compare with built-in trim method
        boolean isEqual = compareStrings(trimmed, input.trim());
        
        // Display results
        System.out.println("Trimmed using method: '" + trimmed + "'");
        System.out.println("Trimmed using built-in: '" + input.trim() + "'");
        System.out.println("Are both equal: " + isEqual);
    }
}
