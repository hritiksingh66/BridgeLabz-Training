import java.io.*;
import java.util.Scanner;

public class ReadCSVFile {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        readCSV(filePath);
        sc.close();
    }
    
    // Read CSV file and print structured data
    public static void readCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                if (isHeader) {
                    System.out.println("=== Student Records ===");
                    isHeader = false;
                    continue;
                }
                
                // Print structured format: ID, Name, Age, Marks
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", 
                                data[0], data[1], data[2], data[3]);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}