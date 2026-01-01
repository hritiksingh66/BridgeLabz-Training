import java.io.*;
import java.nio.charset.StandardCharsets;

// Performance comparison between StringBuilder/StringBuffer and FileReader/InputStreamReader
public class PerformanceComparison {
    
    // Main method to run performance tests
    public static void main(String[] args) {
        // StringBuilder vs StringBuffer comparison
        compareStringConcatenation();
        
        // FileReader vs InputStreamReader comparison
        compareFileReading("large_file.txt");
    }
    
    // Method to compare StringBuilder vs StringBuffer performance
    private static void compareStringConcatenation() {
        int iterations = 1_000_000;
        String text = "hello";
        
        // Test StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        // Test StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        System.out.println("String Concatenation Performance:");
        System.out.println("StringBuilder: " + (stringBuilderTime / 1_000_000) + " ms");
        System.out.println("StringBuffer: " + (stringBufferTime / 1_000_000) + " ms");
        System.out.println();
    }
    
    // Method to compare FileReader vs InputStreamReader performance
    private static void compareFileReading(String fileName) {
        // Test FileReader
        long startTime = System.nanoTime();
        int wordCountFileReader = countWordsWithFileReader(fileName);
        long fileReaderTime = System.nanoTime() - startTime;
        
        // Test InputStreamReader
        startTime = System.nanoTime();
        int wordCountInputStreamReader = countWordsWithInputStreamReader(fileName);
        long inputStreamReaderTime = System.nanoTime() - startTime;
        
        System.out.println("File Reading Performance:");
        System.out.println("FileReader - Words: " + wordCountFileReader + ", Time: " + (fileReaderTime / 1_000_000) + " ms");
        System.out.println("InputStreamReader - Words: " + wordCountInputStreamReader + ", Time: " + (inputStreamReaderTime / 1_000_000) + " ms");
    }
    
    // Helper method to count words using FileReader
    private static int countWordsWithFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error with FileReader: " + e.getMessage());
        }
        return wordCount;
    }
    
    // Helper method to count words using InputStreamReader
    private static int countWordsWithInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}