import java.io.*;
import java.util.Scanner;

public class SearchCSVRecord {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();
        
        searchEmployee(filePath, searchName);
        sc.close();
    }
    
    // Search employee by name and display details
    public static void searchEmployee(String filePath, String searchName) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            boolean found = false;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                String name = data[1].trim();
                
                // Search by name (case insensitive)
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Employee not found: " + searchName);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}