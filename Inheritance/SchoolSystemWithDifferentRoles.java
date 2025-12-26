import java.util.*;

// Base class for all people in school
class Person{
	String name;
	int age;
	
	// Constructor to initialize person properties
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// Method to display basic person information
	void Display() {
		System.out.print("Name: " + name + " Age: " + age);
	}
}

// Teacher class inherits from Person
class Teacher extends Person{
	String subject;
	
	// Constructor calls parent constructor and adds subject
	Teacher(String name, int age, String subject){
		super(name, age);
		this.subject = subject;
	}
	
	// Method to display role
	void displayRole() {
		System.out.println("Role: Teacher");
	}
	
	// Override Display to include subject information
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" Subject: " + subject);
	}
}

// Student class inherits from Person
class Student extends Person{
	String grade;
	
	// Constructor calls parent constructor and adds grade
	Student(String name, int age, String grade){
		super(name, age);
		this.grade = grade;
	}
	
	// Method to display role
	void displayRole() {
		System.out.println("Role: Student");
	}
	
	// Override Display to include grade information
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" Grade: " + grade);
	}
}

// Staff class inherits from Person
class Staff extends Person{
	
	// Constructor calls parent constructor
	Staff(String name, int age){
		super(name, age);
	}
	
	// Method to display role
	void displayRole() {
		System.out.println("Role: Staff");
	}
	
	// Uses parent Display method as-is
	void Display() {
		super.Display();
	}
}

// Main class to demonstrate school system with different roles
public class SchoolSystemWithDifferentRoles {
	public static void main(String[] args) {
		// Create different types of people in school
		Teacher t1 = new Teacher("Alice", 25, "Mathematics");
		Student s1 = new Student("Bob", 15, "A");
		Staff st1 = new Staff("John", 30);
		
		// Display information for each person
		t1.displayRole();
		t1.Display();
		System.out.println();
		
		s1.displayRole();
		s1.Display();
		System.out.println();
		
		st1.displayRole();
		st1.Display();
		System.out.println();
	}
}
