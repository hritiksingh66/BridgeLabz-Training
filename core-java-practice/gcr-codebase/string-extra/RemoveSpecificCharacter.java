// Program to remove specific character from a string
public class RemoveSpecificCharacter {
    
    // Remove all occurrences of specified character from text
    public static String eliminateTargetCharacter(String originalText, char targetChar) {
        StringBuilder modifiedResult = new StringBuilder();
        
        // Check each character and exclude target character
        for (char currentChar : originalText.toCharArray()) {
            if (currentChar != targetChar) {
                modifiedResult.append(currentChar);
            }
        }
        
        return modifiedResult.toString();
    }
    
    public static void main(String[] args) {
        String sourceText = "Hello World";
        char characterToRemove = 'l';
        
        String finalResult = eliminateTargetCharacter(sourceText, characterToRemove);
        
        System.out.println("String: " + sourceText);
        System.out.println("Character to Remove: '" + characterToRemove + "'");
        System.out.println("Modified String: " + finalResult);
    }
}