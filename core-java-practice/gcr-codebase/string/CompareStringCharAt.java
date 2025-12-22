import java.util.*;

// Program to compare strings character by character vs built-in equals method
public class CompareStringCharAt {

    // Compare strings character by character manually
    public static boolean compareCharByChar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    // Compare strings using both methods and display results
    public static void compareStrings() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        
        // Compare using manual method
        boolean result1 = compareCharByChar(s1, s2);
        
        // Compare using built-in method
        boolean result2 = s1.equals(s2);
        
        System.out.println("CharByChar: " + result1);
        System.out.println("Built-in equals(): " + result2);
    }
}
