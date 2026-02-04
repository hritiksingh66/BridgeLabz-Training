import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    
    public static void main(String[] args) {
        String paragraph = "Java is a powerful programming language. " +
                          "Java is widely used for enterprise applications. " +
                          "Programming in Java requires understanding of object-oriented concepts. " +
                          "Java applications can run on any platform that supports Java.";
        
        System.out.println("=== Word Frequency Analysis ===\n");
        System.out.println("Text: " + paragraph);
        System.out.println("\n" + "=".repeat(50));
        
        // Convert to lowercase, split by non-word characters, filter empty strings
        Map<String, Long> wordFrequency = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
        
        System.out.println("\nWord Frequency (using groupingBy + counting):");
        wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue()));
        
        // Alternative using toMap with merge function
        Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\W+"))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.toMap(
                Function.identity(),
                word -> 1,
                Integer::sum
            ));
        
        System.out.println("\nWord Count (using toMap with merge):");
        wordCount.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue()));
        
        // Statistics
        System.out.println("\n=== Statistics ===");
        System.out.println("Total unique words: " + wordFrequency.size());
        System.out.println("Total words: " + wordFrequency.values().stream().mapToLong(Long::longValue).sum());
        
        // Most frequent words
        String mostFrequent = wordFrequency.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("none");
        
        long maxFrequency = wordFrequency.values().stream()
            .max(Long::compareTo)
            .orElse(0L);
        
        System.out.println("Most frequent word: '" + mostFrequent + "' (" + maxFrequency + " times)");
        
        // Words appearing only once
        List<String> uniqueWords = wordFrequency.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println("Words appearing once: " + uniqueWords);
        
        // Words by length
        Map<Integer, List<String>> wordsByLength = wordFrequency.keySet().stream()
            .collect(Collectors.groupingBy(String::length));
        
        System.out.println("\nWords grouped by length:");
        wordsByLength.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> 
                System.out.println(entry.getKey() + " letters: " + entry.getValue()));
    }
}