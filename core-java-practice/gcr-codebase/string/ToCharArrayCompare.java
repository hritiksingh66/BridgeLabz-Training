import java.util.*;

// Program to convert string to char array manually vs built-in method
public class ToCharArrayCompare {
    
    // Convert string to char array manually
    public static char[] userCharArray(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            arr[i] = s.charAt(i);
        return arr;
    }

    // Compare two char arrays
    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input string from user
        String s = sc.next();
        
        // Compare both methods
        char[] userArr = userCharArray(s);
        char[] builtInArr = s.toCharArray();
        boolean result = compareArrays(userArr, builtInArr);
        
        // Display result
        System.out.println("Are arrays equal: " + result);
    }
}
