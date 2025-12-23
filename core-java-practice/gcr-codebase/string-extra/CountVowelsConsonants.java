// Program to count vowels and consonants in a string
public class CountVowelsConsonants {
    
    // Count vowels and consonants in given text
    public static int[] calculateVowelConsonantCount(String inputText) {
        int vowelCount = 0, consonantCount = 0;
        inputText = inputText.toLowerCase();
        
        // Check each character
        for (char character : inputText.toCharArray()) {
            if (Character.isLetter(character)) {
                // Check if character is vowel
                if ("aeiou".indexOf(character) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        
        return new int[]{vowelCount, consonantCount};
    }
    
    public static void main(String[] args) {
        String testString = "Hello World";
        int[] countResult = calculateVowelConsonantCount(testString);
        
        System.out.println("String: " + testString);
        System.out.println("Vowels: " + countResult[0]);
        System.out.println("Consonants: " + countResult[1]);
    }
}