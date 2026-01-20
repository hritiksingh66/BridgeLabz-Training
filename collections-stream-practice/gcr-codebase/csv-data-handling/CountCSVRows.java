import java.io.*;
import java.util.Scanner;

public class CountCSVRows {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        int count = countRows(filePath);
        System.out.println("Number of records (excluding header): " + count);
        
        sc.close();
    }
    
    // Count rows in CSV file excluding header
    public static int countRows(String filePath) {
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header
                    continue;
                }
                count++;
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return count;
    }
}