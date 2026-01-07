import java.io.*;
import java.util.*;

public class WordCounter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file path to count words: ");
        String filePath = scanner.nextLine();
        
        countWordsAndFindTop5(filePath);
        
        scanner.close();
    }
    
    // Count words and display top 5 most frequent
    public static void countWordsAndFindTop5(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words and clean them
                String[] words = line.toLowerCase()
                                   .replaceAll("[^a-zA-Z\\s]", "") // Remove punctuation
                                   .split("\\s+");
                
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }
            
            System.out.println("Total words in file: " + totalWords);
            System.out.println("Unique words: " + wordCount.size());
            
            // Find top 5 most frequent words
            displayTop5Words(wordCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Display top 5 most frequent words
    public static void displayTop5Words(Map<String, Integer> wordCount) {
        // Convert to list and sort by frequency (descending)
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        System.out.println("\nTop 5 Most Frequent Words:");
        System.out.println("=" + "=".repeat(30));
        
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            if (count >= 5) break;
            
            System.out.printf("%d. %-15s : %d occurrences%n", 
                            count + 1, entry.getKey(), entry.getValue());
            count++;
        }
    }
}