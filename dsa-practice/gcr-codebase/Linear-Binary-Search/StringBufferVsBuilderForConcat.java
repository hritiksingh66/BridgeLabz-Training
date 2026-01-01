import java.io.*;
import java.util.*;

// Performance comparison between StringBuilder, StringBuffer, FileReader, and InputStreamReader
public class StringBufferVsBuilderForConcat {
    
    // Test string concatenation performance
    public static void testStringConcatenation() {
        String testString = "hello";
        int iterations = 1000000;
        
        // StringBuilder test
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long sbTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer test
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(testString);
        }
        long sbfTime = System.currentTimeMillis() - startTime;
        
        System.out.println("StringBuilder time: " + sbTime + " ms");
        System.out.println("StringBuffer time: " + sbfTime + " ms");
    }
    
    // Test file reading performance and word count
    public static void testFileReading() {
        String fileName = "large_file.txt";
        createLargeFile(fileName);
        
        // FileReader test
        long startTime = System.currentTimeMillis();
        int wordCountFR = countWordsFileReader(fileName);
        long frTime = System.currentTimeMillis() - startTime;
        
        // InputStreamReader test
        startTime = System.currentTimeMillis();
        int wordCountISR = countWordsInputStreamReader(fileName);
        long isrTime = System.currentTimeMillis() - startTime;
        
        System.out.println("FileReader - Words: " + wordCountFR + ", Time: " + frTime + " ms");
        System.out.println("InputStreamReader - Words: " + wordCountISR + ", Time: " + isrTime + " ms");
        
        // Clean up
        new File(fileName).delete();
    }
    
    // Create large test file
    private static void createLargeFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            String content = "This is a sample text for testing word count performance ";
            for (int i = 0; i < 200000; i++) {
                writer.print(content);
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
    
    // Count words using FileReader
    private static int countWordsFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }
    
    // Count words using InputStreamReader
    private static int countWordsInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
    
    // Main method to run all tests
    public static void main(String[] args) {
        System.out.println("=== String Concatenation Performance Test ===");
        testStringConcatenation();
        
        System.out.println("\n=== File Reading Performance Test ===");
        testFileReading();
    }
}