import java.util.*;

// Employee class demonstrating static, final, and this keywords
class Employee{
	// static variable - shared across all Employee instances
	static String cname = "TCS";
	
	// Instance variables - unique to each Employee object
	String name;
	String des;
	
	// final variable - cannot be changed once initialized
	final int id;
	
	// static counter to track total employees
	static int ec = 0;
	
	// Constructor to initialize Employee object
	Employee(String name, int id, String des){
		// 'this' keyword refers to current object instance
		this.name = name;  // Distinguishes parameter from instance variable
		this.id = id;      // final variable can only be assigned once
		this.des = des;
		ec++;              // Increment static counter
	}
	
	// static method to display employee count - can only access static variables
	static void Count() {
		System.out.println("The Total Employees are: " + ec);
	}
	
	// Method to display employee information
	void Diplay() {
		System.out.println("Employee ID: " + id + " | Name: " + name + " | Designation: " + des + " | Company: " + cname);
	}
}
// Main class demonstrating employee management system
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		// Creating Employee objects - each has unique instance variables but shares static variables
		Employee e1 = new Employee("Alice Johnson", 101, "Software Engineer");
		Employee e2 = new Employee("Bob Smith", 102, "Project Manager");
		Employee e3 = new Employee("Carol White", 103, "UI/UX Designer");
		Employee e4 = new Employee("David Brown", 104, "QA Analyst");
		Employee e5 = new Employee("Eva Green", 105, "Data Scientist");
		
		// Creating a String object to test instanceof operator
		Object e6 = new String("Hello");
		
		// Using instanceof operator to check object type before method calls
		if(e1 instanceof Employee) {
			System.out.println("Instance of Employee");
			e1.Diplay();
		}
		if(e2 instanceof Employee) {
			System.out.println("Instance of Employee");
		    e2.Diplay();
		}
		if(e3 instanceof Employee) {
			System.out.println("Instance of Employee");
		    e3.Diplay();
		}
		if(e4 instanceof Employee) {
			System.out.println("Instance of Employee");
		    e4.Diplay();
		}
		if(e5 instanceof Employee) {
			System.out.println("Instance of Employee");
		    e5.Diplay();
		}
		
		// Testing with non-Employee object
		if(e6 instanceof Employee) {
			System.out.println("Instance of Employee");
		}
		else {
			System.out.println("E6 Not an Instance of Employee");
		}
	}
}
