import java.util.Scanner;

// Program to find string length without using built-in length method
public class FindStringLengthWithoutLengthMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input string from user
        String input = sc.next();
        
        // Compare both methods
        int length1 = getLength(input);
        int length2 = input.length();
        
        System.out.println("User-defined length: " + length1);
        System.out.println("Built-in length: " + length2);
    }

    // Find string length using exception handling
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
}
