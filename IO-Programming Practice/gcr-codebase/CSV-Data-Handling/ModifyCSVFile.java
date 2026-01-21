import java.io.*;
import java.util.*;

public class ModifyCSVFile {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter input CSV file path: ");
        String inputFile = sc.nextLine();
        
        System.out.print("Enter output CSV file path: ");
        String outputFile = sc.nextLine();
        
        increaseSalary(inputFile, outputFile);
        sc.close();
    }
    
    // Increase IT department salary by 10%
    public static void increaseSalary(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
            
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    pw.println(line); // Write header as is
                    isHeader = false;
                    continue;
                }
                
                String[] data = line.split(",");
                String department = data[2].trim();
                
                // Increase salary for IT department by 10%
                if (department.equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3].trim());
                    salary = salary * 1.10; // 10% increase
                    data[3] = String.valueOf((int)salary);
                }
                
                // Write modified record
                pw.println(String.join(",", data));
            }
            
            System.out.println("Updated file saved as: " + outputFile);
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}