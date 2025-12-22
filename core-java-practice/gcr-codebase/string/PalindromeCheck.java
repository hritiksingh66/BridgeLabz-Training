import java.util.Scanner;

// Program to check palindrome using three different approaches
public class PalindromeCheck {

    // Check palindrome using iterative approach
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = findLength(text) - 1;

        // Compare characters from both ends
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Check palindrome using recursive approach
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Check palindrome by comparing with reversed string
    public static boolean isPalindromeUsingReverse(String text) {
        int len = findLength(text);
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        // Compare original with reversed
        for (int i = 0; i < len; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // Reverse string and return as character array
    public static char[] reverseString(String text) {
        int len = findLength(text);
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = text.charAt(len - 1 - i);
        }
        return reversed;
    }

    // Find string length without using built-in method
    public static int findLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return length;
    }

    // Display results from all three approaches
    public static void displayResult(String text) {
        System.out.println("Checking palindrome for: " + text);

        boolean logic1 = isPalindromeIterative(text);
        System.out.println("Logic 1 - Iterative: " + (logic1 ? "Palindrome" : "Not Palindrome"));

        boolean logic2 = isPalindromeRecursive(text, 0, findLength(text) - 1);
        System.out.println("Logic 2 - Recursive: " + (logic2 ? "Palindrome" : "Not Palindrome"));

        boolean logic3 = isPalindromeUsingReverse(text);
        System.out.println("Logic 3 - Using Reverse Array: " + (logic3 ? "Palindrome" : "Not Palindrome"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input text from user
        System.out.print("Enter text to check palindrome: ");
        String input = scanner.nextLine();

        // Check and display results
        displayResult(input);
    }
}
