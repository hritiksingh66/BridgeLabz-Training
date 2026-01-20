import java.io.*;
import java.util.*;

public class SortCSVRecords {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();
        
        sortBySalary(filePath);
        sc.close();
    }
    
    // Sort records by salary in descending order and show top 5
    public static void sortBySalary(String filePath) {
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                records.add(line.split(","));
            }
            
            // Sort by salary (column index 3) in descending order
            records.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3].trim());
                double salaryB = Double.parseDouble(b[3].trim());
                return Double.compare(salaryB, salaryA);
            });
            
            // Display top 5 highest-paid employees
            System.out.println("=== Top 5 Highest-Paid Employees ===");
            int count = Math.min(5, records.size());
            
            for (int i = 0; i < count; i++) {
                String[] data = records.get(i);
                System.out.printf("%d. Name: %s, Department: %s, Salary: %s%n", 
                                (i+1), data[1], data[2], data[3]);
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}