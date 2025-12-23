// Program to reverse a string using character array manipulation
public class ReverseString {
    
    // Reverse the given text by swapping characters from both ends
    public static String createReversedText(String originalText) {
        char[] characterArray = originalText.toCharArray();
        int startPosition = 0, endPosition = characterArray.length - 1;
        
        // Swap characters from both ends moving towards center
        while (startPosition < endPosition) {
            char temporaryChar = characterArray[startPosition];
            characterArray[startPosition] = characterArray[endPosition];
            characterArray[endPosition] = temporaryChar;
            startPosition++;
            endPosition--;
        }
        
        return new String(characterArray);
    }
    
    public static void main(String[] args) {
        String sourceText = "Hello World";
        String reversedText = createReversedText(sourceText);
        
        System.out.println("Original: " + sourceText);
        System.out.println("Reversed: " + reversedText);
    }
}