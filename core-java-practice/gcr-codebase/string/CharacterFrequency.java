import java.util.Scanner;

// Program to find frequency of each character in a string
public class CharacterFrequency {

    // Find string length without using built-in length method
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

    // Find frequency of each character and return as string array
    public static String[][] findFrequencies(String text) {
        int[] freq = new int[256]; // ASCII character frequency array
        int len = findLength(text);

        // Count frequency of each character
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        boolean[] visited = new boolean[256];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
                uniqueCount++;
            }
        }

        // Create result array with character and frequency
        String[][] result = new String[uniqueCount][2];
        boolean[] added = new boolean[256];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                added[ch] = true;
                index++;
            }
        }

        return result;
    }

    // Display character frequency results
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

        // Find and display character frequencies
        String[][] frequencies = findFrequencies(input);
        displayResult(frequencies);
    }
}

