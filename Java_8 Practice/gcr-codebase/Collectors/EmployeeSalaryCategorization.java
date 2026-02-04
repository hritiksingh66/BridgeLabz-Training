import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;
    private String position;
    
    public Employee(String name, String department, double salary, String position) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.position = position;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getPosition() { return position; }
    
    @Override
    public String toString() {
        return String.format("%s (%s) - ₹%,.2f", name, position, salary);
    }
}

public class EmployeeSalaryCategorization {
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", "Engineering", 95000, "Senior Developer"),
            new Employee("Jane Smith", "Engineering", 85000, "Developer"),
            new Employee("Mike Johnson", "Sales", 70000, "Sales Manager"),
            new Employee("Sarah Wilson", "HR", 65000, "HR Specialist"),
            new Employee("David Brown", "Engineering", 120000, "Tech Lead"),
            new Employee("Lisa Davis", "Marketing", 75000, "Marketing Manager"),
            new Employee("Tom Miller", "Sales", 60000, "Sales Executive"),
            new Employee("Amy Taylor", "HR", 80000, "HR Manager"),
            new Employee("Chris Anderson", "Engineering", 90000, "Developer"),
            new Employee("Emma Moore", "Marketing", 55000, "Marketing Executive")
        );
        
        System.out.println("=== Employee Salary Categorization ===\n");
        
        // Group employees by department and calculate average salary
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        
        System.out.println("Average salary by department:");
        avgSalaryByDept.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> 
                System.out.printf("%-12s: ₹%,.2f%n", entry.getKey(), entry.getValue()));
        
        System.out.println("\n=== Detailed Department Analysis ===");
        
        // Group employees by department with full details
        Map<String, List<Employee>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        
        employeesByDept.forEach((dept, empList) -> {
            System.out.println("\n" + dept + " Department:");
            empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(emp -> System.out.println("  " + emp));
            
            double deptAvg = avgSalaryByDept.get(dept);
            System.out.printf("  Department Average: ₹%,.2f%n", deptAvg);
        });
        
        // Additional statistics by department
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
            ));
        
        Map<String, Double> totalSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)
            ));
        
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));
        
        System.out.println("\n=== Department Summary ===");
        avgSalaryByDept.keySet().forEach(dept -> {
            long count = countByDept.get(dept);
            double total = totalSalaryByDept.get(dept);
            double average = avgSalaryByDept.get(dept);
            String highestPaid = highestPaidByDept.get(dept)
                .map(Employee::getName)
                .orElse("None");
            
            System.out.printf("\n%s:%n", dept);
            System.out.printf("  Employees: %d%n", count);
            System.out.printf("  Total Salary: ₹%,.2f%n", total);
            System.out.printf("  Average Salary: ₹%,.2f%n", average);
            System.out.printf("  Highest Paid: %s%n", highestPaid);
        });
        
        // Salary ranges
        Map<String, Map<String, Long>> salaryRangesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.groupingBy(
                    emp -> {
                        if (emp.getSalary() < 60000) return "Below 60K";
                        else if (emp.getSalary() < 80000) return "60K-80K";
                        else if (emp.getSalary() < 100000) return "80K-100K";
                        else return "Above 100K";
                    },
                    Collectors.counting()
                )
            ));
        
        System.out.println("\n=== Salary Distribution by Department ===");
        salaryRangesByDept.forEach((dept, ranges) -> {
            System.out.println("\n" + dept + ":");
            ranges.forEach((range, count) -> 
                System.out.printf("  %-12s: %d employees%n", range, count));
        });
    }
}