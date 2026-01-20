import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first CSV file path (ID, Name, Age): ");
        String file1 = sc.nextLine();
        
        System.out.print("Enter second CSV file path (ID, Marks, Grade): ");
        String file2 = sc.nextLine();
        
        System.out.print("Enter output merged file path: ");
        String outputFile = sc.nextLine();
        
        mergeFiles(file1, file2, outputFile);
        sc.close();
    }
    
    // Merge two CSV files based on ID
    public static void mergeFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> data1 = readFirstFile(file1);
        Map<String, String[]> data2 = readSecondFile(file2);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            // Write merged header
            pw.println("ID,Name,Age,Marks,Grade");
            
            // Merge data based on ID
            for (String id : data1.keySet()) {
                String[] record1 = data1.get(id);
                String[] record2 = data2.get(id);
                
                if (record2 != null) {
                    // Merge: ID, Name, Age, Marks, Grade
                    pw.printf("%s,%s,%s,%s,%s%n", 
                            id, record1[1], record1[2], record2[1], record2[2]);
                }
            }
            
            System.out.println("Files merged successfully: " + outputFile);
            
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }
    }
    
    // Read first file (ID, Name, Age)
    private static Map<String, String[]> readFirstFile(String filePath) {
        Map<String, String[]> data = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] parts = line.split(",");
                data.put(parts[0].trim(), parts);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }
        
        return data;
    }
    
    // Read second file (ID, Marks, Grade)
    private static Map<String, String[]> readSecondFile(String filePath) {
        Map<String, String[]> data = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] parts = line.split(",");
                data.put(parts[0].trim(), parts);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }
        
        return data;
    }
}