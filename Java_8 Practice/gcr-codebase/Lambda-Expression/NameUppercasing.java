import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String id;
    private String name;
    private String department;
    
    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', department='" + department + "'}";
    }
}

public class NameUppercasing {
    
    public static void main(String[] args) {
        // Create list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("E001", "john doe", "HR"),
            new Employee("E002", "jane smith", "IT"),
            new Employee("E003", "bob johnson", "Finance"),
            new Employee("E004", "alice brown", "Marketing")
        );
        
        System.out.println("=== Original Employee Names ===");
        employees.stream()
                .map(Employee::getName)  // Method reference to get name
                .forEach(System.out::println);  // Method reference to print
        
        System.out.println("\n=== Uppercase Names using Method Reference ===");
        // Using String::toUpperCase method reference instead of lambda
        // Instead of: .map(name -> name.toUpperCase())
        List<String> uppercaseNames = employees.stream()
                .map(Employee::getName)      // Get employee names
                .map(String::toUpperCase)    // Convert to uppercase using method reference
                .collect(Collectors.toList());
        
        uppercaseNames.forEach(System.out::println);
        
        System.out.println("\n=== HR Letter Format ===");
        System.out.println("Dear Employees,\n");
        System.out.println("The following employees are invited to the meeting:");
        
        // Create formatted list for HR letter
        employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)    // Method reference for uppercase
                .map(name -> "- " + name)    // Format with bullet point
                .forEach(System.out::println);
        
        System.out.println("\nBest Regards,\nHR Department");
        
        System.out.println("\n=== Department-wise Uppercase Names ===");
        // Group by department and convert names to uppercase
        Map<String, List<String>> departmentNames = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,  // Group by department
                    Collectors.mapping(
                        Employee::getName,     // Get name
                        Collectors.mapping(
                            String::toUpperCase,  // Convert to uppercase
                            Collectors.toList()
                        )
                    )
                ));
        
        departmentNames.forEach((dept, names) -> {
            System.out.println(dept + ": " + names);
        });
    }
}