import java.util.*;

// Base class for all employees
class Employee{
	String name;
	int id;
	int salary;
	
	// Constructor to initialize employee properties
	Employee(String name, int id, int salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	// Method to display employee information
	void Display() {
		System.out.println("Employee ID: " + id + " Name: " + name + " Salary: " + salary);
	}
}

// Manager class inherits from Employee
class Manager extends Employee{
	int teamSize = 15; // Team size for manager
	
	// Constructor calls parent constructor
	Manager(String name, int id, int salary){
		super(name, id, salary);
	}
	
	// Method to display team size
	void showTeamSize() {
		System.out.println("Team Size: " + teamSize);
	}
}

// Developer class inherits from Employee
class Developer extends Employee{
	String language = "Java"; // Programming language
	
	// Constructor calls parent constructor
	Developer(String name, int id, int salary){
		super(name, id, salary);
	}
	
	// Method to display programming language
	void showLanguage() {
		System.out.println("Programming Language: " + language);
	}
}

// Intern class inherits from Employee
class Intern extends Employee{
	
	// Constructor calls parent constructor
	Intern(String name, int id, int salary){
		super(name, id, salary);
	}
	
	// Interns use basic employee functionality
}

// Main class to demonstrate employee hierarchy
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		// Create different types of employees
		Manager m = new Manager("Bob", 106, 65000);
		Developer d = new Developer("John", 102, 50000);
		Intern i = new Intern("Alice", 103, 25000);
		
		// Display employee information
		m.Display();
		m.showTeamSize();
		
		d.Display();
		d.showLanguage();
		
		i.Display();
	}
}
