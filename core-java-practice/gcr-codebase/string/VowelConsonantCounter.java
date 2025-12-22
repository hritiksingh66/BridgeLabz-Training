import java.util.*;

// Program to count vowels and consonants in a string
public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input text from user
        String text = sc.nextLine();
        
        // Count and display results
        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }

    // Check character type
    static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
        
        // Check if letter and classify
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    // Count vowels and consonants in text
    static int[] countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        
        // Loop through all characters
        for (int i = 0; ; i++) {
            try {
                char ch = text.charAt(i);
                String type = checkCharacterType(ch);
                if (type.equals("Vowel")) vowels++;
                else if (type.equals("Consonant")) consonants++;
            } catch (Exception e) {
                break;
            }
        }
        return new int[]{vowels, consonants};
    }
}
