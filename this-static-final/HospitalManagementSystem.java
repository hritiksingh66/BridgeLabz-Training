import java.util.*;

// Patient class demonstrating static, final, and this keywords
class Patient{
	// static variable - shared across all Patient instances
	static String hname = "Appolo Superspeciality Hospital";
	
	// Instance variables - unique to each Patient object
	String name;
	int age;
	String ail;
	
	// final variable - cannot be changed once initialized
	final int ID;
	
	// static counter to track total patients
	static int tp = 0;
	
	// Constructor to initialize Patient object
	Patient(String name, int age, String ail, int ID){
		// 'this' keyword refers to current object instance
		this.name = name;  // Distinguishes parameter from instance variable
		this.age = age;
		this.ail = ail;
		this.ID = ID;      // final variable can only be assigned once
		tp++;              // Increment static counter
	}
	
	// static method to display total patients - can only access static variables
	static void TP() {
		System.out.println("Total Patients are: " + tp);
	}
	
	// Method to display patient information
	void Display() {
		System.out.println("Patient ID: " + ID + " | Name: " + name + " | Age: " + age + " | Ailment: " + ail);
	}
}
// Main class demonstrating hospital management system
public class HospitalManagementSystem {
	public static void main(String[] args) {
		// Creating Patient objects - each has unique instance variables but shares static variables
		Patient p1 = new Patient("John Doe", 30, "Flu", 101);
		Patient p2 = new Patient("Alice Smith", 45, "Diabetes", 102);
		Patient p3 = new Patient("Bob Brown", 60, "Hypertension", 103);
		Patient p4 = new Patient("Carol White", 28, "Cold", 104);
		Patient p5 = new Patient("David Green", 55, "Asthma", 105);
		
		// Creating a String object to test instanceof operator
		Object p6 = new String("Hello");
		
		// Accessing static variable through instance (displays hospital name)
		System.out.println(p1.hname);
		
		// Using instanceof operator to check object type before method calls
		if(p1 instanceof Patient) {
			System.out.println("Instance of Patient");
			p1.Display();
		}
		if(p2 instanceof Patient) {
			System.out.println("Instance of Patient");
			p2.Display();
		}
		if(p3 instanceof Patient) {
			System.out.println("Instance of Patient");
			p3.Display();
		}
		if(p4 instanceof Patient) {
			System.out.println("Instance of Patient");
			p4.Display();
		}
		if(p5 instanceof Patient) {
			System.out.println("Instance of Patient");
			p5.Display();
		}
		
		// Testing with non-Patient object
		if(p6 instanceof Patient) {
			System.out.println("Instance of Patient");
		}
		else {
			System.out.println("P6 Not an Instance of Patient");
		}
		
		// Calling static method using class name (recommended approach)
		Patient.TP();
	}
}
