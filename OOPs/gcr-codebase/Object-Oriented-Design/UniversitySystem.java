import java.util.*;

// Faculty class - can exist independently
class Faculty {
    String name;
    String subject;
    
    Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    
    void showInfo() {
        System.out.println("Faculty: " + name + " teaches " + subject);
    }
}

// Department class - depends on University (Composition)
class Department {
    String name;
    List<Faculty> faculties; // Aggregation - department has faculties
    
    Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }
    
    // Add faculty to department
    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    
    // Show department info
    void showInfo() {
        System.out.println("Department: " + name);
        for (Faculty f : faculties) {
            System.out.println("  - " + f.name);
        }
    }
}

// University class - owns departments (Composition)
class University {
    String name;
    List<Department> departments; // Composition - university owns departments
    
    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    // Create and add department (Composition)
    Department createDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }
    
    // Show university info
    void showInfo() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.showInfo();
        }
    }
    
    // When university is deleted, departments are also deleted (Composition)
    void closeUniversity() {
        System.out.println("Closing " + name + " - All departments will be deleted");
        departments.clear(); // Departments deleted with university
    }
}

// Main class to demonstrate the system
public class UniversitySystem {
    public static void main(String[] args) {
        // Create university
        University uni = new University("XYZ University");
        
        // Create departments (Composition - departments belong to university)
        Department csDept = uni.createDepartment("Computer Science");
        Department mathDept = uni.createDepartment("Mathematics");
        
        // Create faculty (can exist independently)
        Faculty prof1 = new Faculty("Dr. Smith", "Java Programming");
        Faculty prof2 = new Faculty("Dr. Johnson", "Data Structures");
        Faculty prof3 = new Faculty("Dr. Brown", "Calculus");
        
        // Add faculty to departments (Aggregation)
        csDept.addFaculty(prof1);
        csDept.addFaculty(prof2);
        mathDept.addFaculty(prof3);
        
        // Show university structure
        uni.showInfo();
        System.out.println();
        
        // Faculty can exist without department
        System.out.println("Faculty can exist independently:");
        prof1.showInfo();
        System.out.println();
        
        // Demonstrate composition - closing university deletes departments
        uni.closeUniversity();
        
        // But faculty still exists
        System.out.println("Faculty still exists after university closure:");
        prof1.showInfo();
        prof2.showInfo();
        prof3.showInfo();
    }
}