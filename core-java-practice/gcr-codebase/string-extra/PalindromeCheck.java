// Program to check if a string is a palindrome
public class PalindromeCheck {
    
    // Check if given text reads same forwards and backwards
    public static boolean verifyPalindrome(String inputText) {
        // Clean text: lowercase and remove non-alphanumeric characters
        inputText = inputText.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int startIndex = 0, endIndex = inputText.length() - 1;
        
        // Compare characters from both ends
        while (startIndex < endIndex) {
            if (inputText.charAt(startIndex) != inputText.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] testPhrases = {"racecar", "A man a plan a canal Panama", "race a car", "hello"};
        
        // Test each phrase for palindrome
        for (String phrase : testPhrases) {
            System.out.println("\"" + phrase + "\" is " + (verifyPalindrome(phrase) ? "" : "not ") + "a palindrome");
        }
    }
}