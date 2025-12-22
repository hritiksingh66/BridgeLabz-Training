import java.util.Scanner;

// Program to find unique characters in a string
public class UniqueCharacters {

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

    // Find all unique characters in the string
    public static char[] findUniqueChars(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int uniqueCount = 0;

        // Check each character for uniqueness
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // Check if character already appeared
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // Add to unique array if not found before
            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create result array with exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find and display unique characters
        char[] uniqueCharacters = findUniqueChars(input);

        System.out.print("Unique characters in the string: ");
        for (char c : uniqueCharacters) {
            System.out.print(c + " ");
        }
    }
}
