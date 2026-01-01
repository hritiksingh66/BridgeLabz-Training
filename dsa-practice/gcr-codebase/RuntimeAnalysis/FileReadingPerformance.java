import java.io.*;
import java.nio.charset.StandardCharsets;

// Performance comparison between FileReader and InputStreamReader
public class FileReadingPerformance {
    
    // Method to create test file of specified size
    public static void createTestFile(String fileName, int sizeInMB) {
        try (FileWriter writer = new FileWriter(fileName)) {
            String line = "This is a test line for performance comparison.\n";
            int linesNeeded = (sizeInMB * 1024 * 1024) / line.length();
            
            for (int i = 0; i < linesNeeded; i++) {
                writer.write(line);
            }
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    // Method to read file using FileReader
    public static long readWithFileReader(String fileName) {
        long startTime = System.nanoTime();
        
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            while (bufferedReader.readLine() != null) {
                // Read line by line
            }
            
        } catch (IOException e) {
            System.out.println("Error with FileReader: " + e.getMessage());
        }
        
        return System.nanoTime() - startTime;
    }
    
    // Method to read file using InputStreamReader
    public static long readWithInputStreamReader(String fileName) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            while (bufferedReader.readLine() != null) {
                // Read line by line
            }
            
        } catch (IOException e) {
            System.out.println("Error with InputStreamReader: " + e.getMessage());
        }
        
        return System.nanoTime() - startTime;
    }
    
    // Main method to compare file reading performance
    public static void main(String[] args) {
        int[] fileSizes = {1, 10, 50}; // MB
        
        for (int size : fileSizes) {
            String fileName = "test_" + size + "MB.txt";
            createTestFile(fileName, size);
            
            long fileReaderTime = readWithFileReader(fileName);
            long inputStreamReaderTime = readWithInputStreamReader(fileName);
            
            System.out.println("File Size: " + size + "MB");
            System.out.println("FileReader: " + (fileReaderTime / 1_000_000.0) + " ms");
            System.out.println("InputStreamReader: " + (inputStreamReaderTime / 1_000_000.0) + " ms");
            System.out.println();
            
            // Clean up
            new File(fileName).delete();
        }
    }
}