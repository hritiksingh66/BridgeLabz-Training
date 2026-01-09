import java.io.*;
import java.util.Scanner;

public class TryWithResources {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file name to read (default: info.txt): ");
        String fileName = scanner.nextLine();
        if (fileName.trim().isEmpty()) {
            fileName = "info.txt";
        }
        
        readFirstLine(fileName);
        scanner.close();
    }
    
    // Method using try-with-resources for automatic resource management
    public static void readFirstLine(String fileName) {
        // BufferedReader automatically closed after try block
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error reading file");
        }
    }
}