import java.io.*;
import java.util.Scanner;

public class WriteCSVFile {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter output CSV file name: ");
        String fileName = sc.nextLine();
        
        writeEmployeeData(fileName);
        sc.close();
    }
    
    // Write employee data to CSV file
    public static void writeEmployeeData(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            // Write header
            pw.println("ID,Name,Department,Salary");
            
            // Write 5 employee records
            pw.println("1,John Doe,IT,75000");
            pw.println("2,Jane Smith,HR,65000");
            pw.println("3,Mike Johnson,Finance,70000");
            pw.println("4,Sarah Wilson,IT,80000");
            pw.println("5,David Brown,Marketing,60000");
            
            System.out.println("Employee data written to " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}