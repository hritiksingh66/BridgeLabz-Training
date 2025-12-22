import java.util.Scanner;

// Program to check if two strings are anagrams
public class AnagramCheck {

    // Find string length without using built-in length method
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

    // Check if two strings are anagrams using character frequency
    public static boolean areAnagrams(String text1, String text2) {
        int len1 = findLength(text1);
        int len2 = findLength(text2);

        // Different lengths cannot be anagrams
        if (len1 != len2) {
            return false;
        }

        // Count frequency of each character
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < len1; i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input strings from user
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        // Check and display result
        boolean result = areAnagrams(text1, text2);

        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are NOT anagrams.");
        }
    }
}