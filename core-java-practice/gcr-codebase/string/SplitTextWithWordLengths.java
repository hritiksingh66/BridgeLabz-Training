import java.util.Scanner;

// Program to split text and display word lengths
public class SplitTextWithWordLengths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input text from user
        String input = sc.nextLine();
        
        // Split text and get word lengths
        String[] words = splitText(input);
        String[][] wordLengths = getWordLengths(words);
        
        // Display results in table format
        System.out.println("Word\tLength");
        for (String[] row : wordLengths) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }

    // Split text manually by spaces
    public static String[] splitText(String text) {
        // Count number of words
        int count = 1;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') count++;
            } catch (Exception e) {
                break;
            }
        }
        
        // Extract words
        String[] words = new String[count];
        int start = 0, idx = 0;
        for (int i = 0;; i++) {
            try {
                if (text.charAt(i) == ' ') {
                    words[idx++] = getSubstring(text, start, i);
                    start = i + 1;
                }
            } catch (Exception e) {
                words[idx] = getSubstring(text, start, i);
                break;
            }
        }
        return words;
    }

    // Get substring manually
    public static String getSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += text.charAt(i);
        return result;
    }

    // Get string length without using built-in method
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

    // Create array with words and their lengths
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
