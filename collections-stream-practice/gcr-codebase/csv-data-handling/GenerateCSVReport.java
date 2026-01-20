import java.io.*;
import java.util.*;

// Employee class for database simulation
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class GenerateCSVReport {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter output CSV report file name: ");
        String fileName = sc.nextLine();
        
        generateReport(fileName);
        sc.close();
    }
    
    // Generate CSV report from simulated database
    public static void generateReport(String fileName) {
        // Simulate database records
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Doe", "IT", 75000),
            new Employee(2, "Jane Smith", "HR", 65000),
            new Employee(3, "Mike Johnson", "Finance", 70000),
            new Employee(4, "Sarah Wilson", "IT", 80000),
            new Employee(5, "David Brown", "Marketing", 60000),
            new Employee(6, "Lisa Davis", "Finance", 72000),
            new Employee(7, "Tom Wilson", "HR", 68000)
        );
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            // Write CSV header
            pw.println("Employee ID,Name,Department,Salary");
            
            // Write employee records
            for (Employee emp : employees) {
                pw.printf("%d,%s,%s,%.2f%n", 
                         emp.getId(), emp.getName(), 
                         emp.getDepartment(), emp.getSalary());
            }
            
            System.out.println("CSV report generated: " + fileName);
            System.out.println("Total employees: " + employees.size());
            
        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}