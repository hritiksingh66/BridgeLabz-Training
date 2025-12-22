import java.util.Scanner;

// Program to find character frequency using unique character approach
public class FrequencyUsingUniqueChar {

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

    // Find unique characters in the string
    public static char[] uniqueCharacters(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int count = 0;

        // Find unique characters
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[count++] = current;
            }
        }

        // Create result array with exact size
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    // Find frequencies using unique characters
    public static String[][] findFrequencies(String text) {
        int[] freq = new int[256]; // ASCII frequency array
        int len = findLength(text);

        // Count frequency of each character
        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        // Get unique characters and create result
        char[] uniqueChars = uniqueCharacters(text);
        int uniqueLen = findLength(new String(uniqueChars));
        String[][] result = new String[uniqueLen][2];

        for (int i = 0; i < uniqueLen; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    // Display frequency results in table format
    public static void displayResult(String[][] result) {
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        System.out.println("------------------------");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-10s\n", result[i][0], result[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find and display frequencies
        String[][] frequencies = findFrequencies(input);
        displayResult(frequencies);
    }
}

