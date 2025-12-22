import java.util.Scanner;

// Program to split text manually and compare with built-in split method
public class SplitTextAndCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input text from user
        String input = sc.nextLine();
        
        // Split using both methods
        String[] userWords = splitText(input);
        String[] builtInWords = input.split(" ");
        
        // Compare results
        boolean result = compare(userWords, builtInWords);
        
        // Display results
        System.out.println("User-defined split:");
        for (String word : userWords) System.out.println(word);
        System.out.println("Built-in split:");
        for (String word : builtInWords) System.out.println(word);
        System.out.println("Are both arrays equal? " + result);
    }

    // Split text manually by spaces
    public static String[] splitText(String text) {
        // Count number of words
        int count = 1;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') count++;
            } catch (Exception e) {
                break;
            }
        }
        
        // Extract words
        String[] words = new String[count];
        int start = 0, idx = 0;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') {
                    words[idx++] = getSubstring(text, start, i);
                    start = i + 1;
                }
            } catch (Exception e) {
                words[idx] = getSubstring(text, start, i);
                break;
            }
        }
        return words;
    }

    // Get substring manually
    public static String getSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += text.charAt(i);
        return result;
    }

    // Compare two string arrays
    public static boolean compare(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
}
