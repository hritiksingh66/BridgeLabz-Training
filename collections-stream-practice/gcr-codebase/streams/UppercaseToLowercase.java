import java.io.*;
import java.util.Scanner;

public class UppercaseToLowercase {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter source file path: ");
        String sourcePath = scanner.nextLine();
        
        System.out.print("Enter destination file path: ");
        String destPath = scanner.nextLine();
        
        convertToLowercase(sourcePath, destPath);
        
        scanner.close();
    }
    
    // Convert uppercase letters to lowercase using BufferedReader/Writer
    public static void convertToLowercase(String sourcePath, String destPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase and write
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            
            System.out.println("File converted to lowercase successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourcePath);
        } catch (IOException e) {
            System.out.println("Error during conversion: " + e.getMessage());
        }
    }
}