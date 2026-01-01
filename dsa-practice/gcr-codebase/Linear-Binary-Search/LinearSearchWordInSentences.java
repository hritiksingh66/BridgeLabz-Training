// Linear search to find sentence containing a word
public class LinearSearchWordInSentences {
    
    // Method to find sentence containing target word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
    
    // Main method to test word search in sentences
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps",
            "Java is a programming language",
            "Linear search is simple",
            "Binary search is efficient"
        };
        String targetWord = "programming";
        
        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }
}