import java.util.*;

// Base class for restaurant personnel
class PersonR{
	String name;
	int id;
	
	// Constructor to initialize person properties
	PersonR(String name, int id){
		this.name = name;
		this.id = id;
	}
}

// Interface defining worker behavior
interface Worker{
	void performDuties(); // Method to perform job duties
}

// Chef class inherits from PersonR and implements Worker
class Chef extends PersonR implements Worker{
	
	// Constructor calls parent constructor
	Chef(String name, int id){
		super(name, id);
	}
	
	// Implementation of Worker interface method
	public void performDuties() {
		System.out.println(name +  " (Chef) is cooking meals");
	}
}

// Waiter class inherits from PersonR and implements Worker
class Waiter extends PersonR implements Worker{
	
	// Constructor calls parent constructor
	Waiter(String name, int id){
		super(name, id);
	}
	
	// Implementation of Worker interface method
	public void performDuties() {
		System.out.println(name +  " (Waiter) is serving customers");
	}
}

// Main class to demonstrate restaurant management system
public class RestaurantManagementSystem {
	public static void main(String[] args) {
		// Create restaurant staff
		Chef c1 = new Chef("Alice", 124);
		Waiter w1 = new Waiter("Bob", 102);
		
		// Demonstrate polymorphism - both perform their duties
		c1.performDuties();
		w1.performDuties();
	}
}
