import java.io.*;
import java.util.Scanner;

public class ReadLargeCSV {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter large CSV file path: ");
        String filePath = sc.nextLine();
        
        readInChunks(filePath);
        sc.close();
    }
    
    // Read large CSV file in chunks of 100 lines
    public static void readInChunks(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int totalRecords = 0;
            int chunkCount = 0;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                totalRecords++;
                
                // Process in chunks of 100
                if (totalRecords % 100 == 0) {
                    chunkCount++;
                    System.out.println("Processed chunk " + chunkCount + 
                                     " - Total records: " + totalRecords);
                    
                    // Simulate processing delay
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            
            // Handle remaining records
            if (totalRecords % 100 != 0) {
                chunkCount++;
                System.out.println("Processed final chunk " + chunkCount + 
                                 " - Total records: " + totalRecords);
            }
            
            System.out.println("=== Processing Complete ===");
            System.out.println("Total chunks processed: " + chunkCount);
            System.out.println("Total records: " + totalRecords);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}