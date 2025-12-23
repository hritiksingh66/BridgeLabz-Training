// Program to find the longest word in a sentence
public class LongestWord {
    
    // Find the word with maximum length in given sentence
    public static String locateLongestWord(String textSentence) {
        String[] wordArray = textSentence.split("\\s+");
        String maxLengthWord = "";
        
        // Compare each word length
        for (String currentWord : wordArray) {
            if (currentWord.length() > maxLengthWord.length()) {
                maxLengthWord = currentWord;
            }
        }
        
        return maxLengthWord;
    }
    
    public static void main(String[] args) {
        String inputSentence = "The quick brown fox jumps over the lazy dog";
        String biggestWord = locateLongestWord(inputSentence);
        
        System.out.println("Sentence: " + inputSentence);
        System.out.println("Longest word: " + biggestWord);
        System.out.println("Length: " + biggestWord.length());
    }
}