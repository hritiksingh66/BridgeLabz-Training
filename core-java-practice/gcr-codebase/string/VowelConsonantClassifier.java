import java.util.Scanner;

// Program to classify each character as vowel, consonant, or not a letter
public class VowelConsonantClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input text from user
        String text = sc.nextLine();
        
        // Classify and display results
        String[][] result = classifyCharacters(text);
        displayResult(result);
    }

    // Check if character is vowel, consonant, or not a letter
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        
        // Check if it's a letter
        if ((ch >= 'a' && ch <= 'z')) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Classify all characters in the text
    public static String[][] classifyCharacters(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    // Display classification results in table format
    public static void displayResult(String[][] arr) {
        System.out.println("Character\tType");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }
}
