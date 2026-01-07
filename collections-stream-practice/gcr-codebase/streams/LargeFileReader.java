import java.io.*;
import java.util.Scanner;

public class LargeFileReader {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file path to search for errors: ");
        String filePath = scanner.nextLine();
        
        findErrorLines(filePath);
        
        scanner.close();
    }
    
    // Read large file line by line and find lines containing "error"
    public static void findErrorLines(String filePath) {
        int lineNumber = 0;
        int errorCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            System.out.println("Lines containing 'error' (case insensitive):");
            System.out.println("=" + "=".repeat(50));
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                // Check if line contains "error" (case insensitive)
                if (line.toLowerCase().contains("error")) {
                    errorCount++;
                    System.out.println("Line " + lineNumber + ": " + line.trim());
                }
                
                // Show progress for large files (every 10000 lines)
                if (lineNumber % 10000 == 0) {
                    System.out.println("Processed " + lineNumber + " lines...");
                }
            }
            
            System.out.println("=" + "=".repeat(50));
            System.out.println("Total lines processed: " + lineNumber);
            System.out.println("Lines with errors found: " + errorCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}