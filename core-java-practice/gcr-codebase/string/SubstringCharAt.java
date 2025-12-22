import java.util.*;

// Program to create substring using charAt vs built-in substring method
public class SubstringCharAt {
    
    // Create substring manually using charAt
    public static String substringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++)
            result += text.charAt(i);
        return result;
    }

    // Compare two strings character by character
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        // Compare both methods
        String s1 = substringUsingCharAt(text, start, end);
        String s2 = text.substring(start, end);
        boolean result = compareStrings(s1, s2);
        
        // Display results
        System.out.println("CharAt Substring: " + s1);
        System.out.println("Built-in Substring: " + s2);
        System.out.println("Are equal: " + result);
    }
}

