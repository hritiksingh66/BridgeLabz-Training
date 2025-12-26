import java.util.*;

// Student class demonstrating static, final, and this keywords
class Student{
	// static variable - shared across all Student instances
	static String uname = "GLA University";
	
	// Instance variables - unique to each Student object
	String name;
	char Grade;
	
	// final variable - cannot be changed once initialized
	final int roll;
	
	// static counter to track total students
	static int ts = 0;
	
	// Constructor to initialize Student object
	Student(String name, int roll, char Grade){
		// 'this' keyword refers to current object instance
		this.name = name;   // Distinguishes parameter from instance variable
		this.roll = roll;   // final variable can only be assigned once
		this.Grade = Grade;
		ts++;               // Increment static counter
	}
	
	// static method to display total students - can only access static variables
	static void Total(){
		System.out.println("Total Students are: " + ts);
	}
	
	// Method to display student information
	void Display() {
		System.out.println("Student Roll Number: " + roll + " | Name: " + name + " | Grade: " + Grade + " | University: " + uname);
	}
}
// Main class demonstrating university student management system
public class UniversityStudentManagement {
	public static void main(String[] args) {
		// Creating Student objects - each has unique instance variables but shares static variables
		Student s1 = new Student("John Doe", 101, 'A');
		Student s2 = new Student("Alice Smith", 102, 'B');
		Student s3 = new Student("Bob Brown", 103, 'A');
		Student s4 = new Student("Charlie White", 104, 'C');
		Student s5 = new Student("Diana Green", 105, 'B');
		
		// Creating a String object to test instanceof operator
		Object s6 = new String("Hello");
		
		// Using instanceof operator to check object type before method calls
		if(s1 instanceof Student) {
			System.out.println("Instance of Student");
			s1.Display();
		}
		if(s2 instanceof Student) {
			System.out.println("Instance of Student");
			s2.Display();
		}
		if(s3 instanceof Student) {
			System.out.println("Instance of Student");
			s3.Display();
		}
		if(s4 instanceof Student) {
			System.out.println("Instance of Student");
			s4.Display();
		}
		if(s5 instanceof Student) {
			System.out.println("Instance of Student");
			s5.Display();
		}
		
		// Testing with non-Student object
		if(s6 instanceof Student) {
			System.out.println("Instance of Student");
		}
		else{
			System.out.println("S6 Not an Instance of Student");
		}
	}
}
