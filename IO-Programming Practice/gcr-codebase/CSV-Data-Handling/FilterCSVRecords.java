import java.io.*;
import java.util.Scanner;

public class FilterCSVRecords {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        filterHighScorers(filePath);
        sc.close();
    }
    
    // Filter students with marks > 80
    public static void filterHighScorers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            System.out.println("=== Students with Marks > 80 ===");
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3].trim());
                
                // Filter condition: marks > 80
                if (marks > 80) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %d%n", 
                                    data[0], data[1], data[2], marks);
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}