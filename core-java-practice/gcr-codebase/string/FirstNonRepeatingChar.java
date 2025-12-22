import java.util.Scanner;

// Program to find first non-repeating character in a string
public class FirstNonRepeatingChar {

    // Find string length without using built-in method
    public static int findLength(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return length;
    }

    // Find first non-repeating character
    public static char findFirstNonRepeating(String text) {
        int[] freq = new int[256]; // ASCII character frequency array
        int len = findLength(text);

        // Count frequency of each character
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return null character if no non-repeating found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find and display result
        char result = findFirstNonRepeating(input);

        if (result != '\0') {
            System.out.println("First non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
