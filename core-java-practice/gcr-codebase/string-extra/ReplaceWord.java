// Program to replace specific word in a sentence with another word
public class ReplaceWord {
    
    // Replace all occurrences of target word with replacement word
    public static String substituteWord(String originalSentence, String targetWord, String replacementWord) {
        StringBuilder modifiedResult = new StringBuilder();
        String[] wordTokens = originalSentence.split("\\s+");
        
        // Process each word in the sentence
        for (int wordIndex = 0; wordIndex < wordTokens.length; wordIndex++) {
            if (wordTokens[wordIndex].equals(targetWord)) {
                modifiedResult.append(replacementWord);
            } else {
                modifiedResult.append(wordTokens[wordIndex]);
            }
            
            // Add space between words (except for last word)
            if (wordIndex < wordTokens.length - 1) {
                modifiedResult.append(" ");
            }
        }
        
        return modifiedResult.toString();
    }
    
    public static void main(String[] args) {
        String inputSentence = "Java is a programming language and Java is powerful";
        String wordToReplace = "Java";
        String newWord = "Python";
        
        String finalResult = substituteWord(inputSentence, wordToReplace, newWord);
        
        System.out.println("Original: " + inputSentence);
        System.out.println("Replace '" + wordToReplace + "' with '" + newWord + "'");
        System.out.println("Result: " + finalResult);
    }
}