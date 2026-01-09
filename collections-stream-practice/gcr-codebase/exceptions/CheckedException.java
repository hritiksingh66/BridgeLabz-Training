import java.io.*;
import java.util.Scanner;

public class CheckedException {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file name to read (default: data.txt): ");
        String fileName = scanner.nextLine();
        if (fileName.trim().isEmpty()) {
            fileName = "data.txt";
        }
        
        readFile(fileName);
        scanner.close();
    }
    
    // Method to read file and handle IOException
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle checked exception
            System.out.println("File not found");
        }
    }
}