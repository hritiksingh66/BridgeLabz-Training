import java.io.*;
import java.util.Scanner;

public class FileReadWrite {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get file paths from user
        System.out.print("Enter source file path: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destPath = scanner.nextLine();
        
        copyFile(sourcePath, destPath);
        scanner.close();
    }
    
    // Copy file using FileInputStream and FileOutputStream
    public static void copyFile(String sourcePath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(destPath);
            
            int data;
            // Read byte by byte and write to destination
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            
            System.out.println("File copied successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourcePath);
        } catch (IOException e) {
            System.out.println("Error during file operation: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}