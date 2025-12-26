import java.util.*;

// Vehicle class demonstrating static, final, and this keywords
class Vehicle{
	// static variable - shared across all Vehicle instances
	static int fee = 10000;
	
	// Instance variables - unique to each Vehicle object
	String name;
	String type;
	
	// final variable - cannot be changed once initialized
	final int number;
	
	// Constructor to initialize Vehicle object
	Vehicle(String name, String type, int number){
		// 'this' keyword refers to current object instance
		this.name = name;     // Distinguishes parameter from instance variable
		this.type = type;
		this.number = number; // final variable can only be assigned once
	}
	
	// static method to update registration fee - can only access static variables
	static void Update(int u) {
		fee = u;  // Modifying static variable
		System.out.println("The Updated Registration Fees is: " + fee);
	}
	
	// Method to display vehicle information
	void Display() {
		System.out.println("Vehicle Number: " + number + " | Owner Name: " + name + " | Vehicle Type: " + type + " | Registration Fee (₹): " + fee);
	}
}
// Main class demonstrating vehicle registration system
public class VehicleRegistrationSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Creating Vehicle objects - each has unique instance variables but shares static fee
		Vehicle v1 = new Vehicle("John Doe", "Car", 12345);
		Vehicle v2 = new Vehicle("Alice Smith", "Motorcycle", 67890);
		Vehicle v3 = new Vehicle("Bob Brown", "Truck", 11223);
		Vehicle v4 = new Vehicle("Carol White", "SUV", 44556);
		Vehicle v5 = new Vehicle("David Green", "Bicycle", 78901);
		
		// Creating a String object to test instanceof operator
		Object v6 = new String("Hello");
		
		// Using instanceof operator to check object type before method calls
		if(v1 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
			v1.Display();
		}
		if(v2 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
			v2.Display();
		}
		if(v3 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
			v3.Display();
		}
		if(v4 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
			v4.Display();
		}
		if(v5 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
			v5.Display();
		}
		
		// Testing with non-Vehicle object
		if(v6 instanceof Vehicle) {
			System.out.println("Instance of Vehicle");
		}
		else {
			System.out.println("V6 Not an Instance of Vehicle");
		}
		
		// Interactive menu for updating registration fee (static variable)
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.print("Do you want to update the registration fees: ");
		int c = sc.nextInt();
		
		if(c == 1) {
			System.out.print("Enter new Registration Fees: ");
			int u = sc.nextInt();
			// Calling static method using class name (recommended approach)
			Vehicle.Update(u);
			
			// Displaying all vehicles with updated fee (static variable affects all instances)
			v1.Display();
			v2.Display();
			v3.Display();
			v4.Display();
			v5.Display();
		}
		else if(c == 2){
			System.out.println("Exit");
		}
		else {
			System.out.println("Invalid Choice");
		}
	}
}
