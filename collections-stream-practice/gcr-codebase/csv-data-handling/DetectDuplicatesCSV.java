import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        detectDuplicates(filePath);
        sc.close();
    }
    
    // Detect duplicate entries based on ID column
    public static void detectDuplicates(String filePath) {
        Map<String, List<String>> idMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int lineNumber = 1;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    lineNumber++;
                    continue;
                }
                
                String[] data = line.split(",");
                String id = data[0].trim();
                
                // Track occurrences of each ID
                idMap.computeIfAbsent(id, k -> new ArrayList<>()).add(
                    "Line " + lineNumber + ": " + line
                );
                
                lineNumber++;
            }
            
            // Find and display duplicates
            System.out.println("=== Duplicate Records ===");
            boolean foundDuplicates = false;
            
            for (Map.Entry<String, List<String>> entry : idMap.entrySet()) {
                if (entry.getValue().size() > 1) {
                    foundDuplicates = true;
                    System.out.println("Duplicate ID: " + entry.getKey());
                    for (String record : entry.getValue()) {
                        System.out.println("  " + record);
                    }
                    System.out.println();
                }
            }
            
            if (!foundDuplicates) {
                System.out.println("No duplicate records found.");
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}