import java.util.*;

// Abstract base class for employees - demonstrates encapsulation
abstract class Employee{
	// Private fields - encapsulated data
	private int id;
	private String name;
	private int baseSalary;
	
	// Constructor to initialize employee
	Employee(int id, String name, int baseSalary){
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	// Abstract method - must be implemented by child classes
	public abstract int calculateSalary();
	
	// Method to display employee details
	void displayDetails() {
		System.out.println("Employee ID: " + id + " Name: " + name + " Base Salary: " + baseSalary + " Final Salary: " + calculateSalary());
	}
	
	// Setter method for ID
	void SetID(int id) {
		this.id = id;
	}
	
	// Getter method for ID
	int GetID() {
		return id;
	}
	
	// Setter method for name
	void SetN(String name) {
		this.name = name;
	}
	
	// Getter method for name
	String GetN() {
		return name;
	}
	
	// Setter method for salary
	void SetS(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	// Getter method for salary
	int GetS() {
		return baseSalary;
	}
}

// Interface for department functionality
interface Department{
	void assignDepartment(String department);
	String getDepartment();
}

// Full-time employee class extends Employee and implements Department
class FullTimeEmployee extends Employee implements Department{
	private String department;
	
	// Constructor calls parent constructor
	FullTimeEmployee(int id, String name, int baseSalary){
		super(id, name, baseSalary);
	}
	
	// Implementation of abstract method - full-time gets base salary
	public int calculateSalary(){
		return GetS();
	}
	
	// Implementation of interface method
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	// Implementation of interface method
	public String getDepartment(){
		return department;
	}
}

// Part-time employee class extends Employee and implements Department
class PartTimeEmployee extends Employee implements Department{
	private int hoursWorked;
	private int hourlyRate;
	private String department;
	
	// Constructor calls parent constructor and adds part-time specific fields
	PartTimeEmployee(int id, String name, int baseSalary, int hoursWorked, int hourlyRate, String department){
		super(id, name, baseSalary);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		this.department = department;
	}
	
	// Implementation of abstract method - part-time gets base + hourly pay
	public int calculateSalary() {
		int totalSalary = GetS() + (hoursWorked * hourlyRate);
		return totalSalary;
	}
	
	// Implementation of interface method
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	// Implementation of interface method
	public String getDepartment() {
		return department;
	}
}

// Main class to demonstrate employee management system
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		// Create full-time employee
		FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000);
		fte.assignDepartment("Engineering");
		fte.displayDetails();
		System.out.println("Department: " + fte.getDepartment());
		
		// Create part-time employee
		PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 10000, 20, 300, "Support");
		pte.assignDepartment("Customer Service");
		pte.displayDetails();
		System.out.println("Department: " + pte.getDepartment());
	}
}
