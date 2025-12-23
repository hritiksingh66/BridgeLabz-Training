// Program to toggle case of each character in a string
public class ToggleCase {
    
    // Convert uppercase to lowercase and vice versa for each character
    public static String switchCharacterCase(String originalText) {
        StringBuilder modfiedReslt = new StringBuilder();
        
        // Process each character in the string
        for (char currChar : originalText.toCharArray()) {
            if (Character.isUpperCase(currChar)) {
                // Convert uppercase to lowercase
                modfiedReslt.append(Character.toLowerCase(currChar));
            } else if (Character.isLowerCase(currChar)) {
                // Convert lowercase to uppercase
                modfiedReslt.append(Character.toUpperCase(currChar));
            } else {
                // Keep non-alphabetic characters unchanged
                modfiedReslt.append(currChar);
            }
        }
        
        return modfiedReslt.toString();
    }
    
    public static void main(String[] args) {
        String srcTxt = "Hello World 123!";
        String toglText = switchCharacterCase(srcTxt);
        
        System.out.println("Original: " + srcTxt);
        System.out.println("Toggled: " + toglText);
    }
}