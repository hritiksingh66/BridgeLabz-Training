import java.io.*;
import java.util.*;

// Serializable Employee class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
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
    
    @Override
    public String toString() {
        return String.format("Employee[ID=%d, Name=%s, Dept=%s, Salary=%.2f]", 
                           id, name, department, salary);
    }
}

public class EmployeeSerialization {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file name to save employees: ");
        String fileName = scanner.nextLine();
        
        // Create employee list
        List<Employee> employees = createEmployeeList(scanner);
        
        // Serialize employees
        serializeEmployees(employees, fileName);
        
        // Deserialize and display
        deserializeEmployees(fileName);
        
        scanner.close();
    }
    
    // Create list of employees from user input
    public static List<Employee> createEmployeeList(Scanner scanner) {
        List<Employee> employees = new ArrayList<>();
        
        System.out.print("Enter number of employees: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        for (int i = 0; i < count; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Department: ");
            String dept = scanner.nextLine();
            
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            
            employees.add(new Employee(id, name, dept, salary));
        }
        
        return employees;
    }
    
    // Serialize employee list to file
    public static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
    
    // Deserialize employee list from file
    @SuppressWarnings("unchecked")
    public static void deserializeEmployees(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}