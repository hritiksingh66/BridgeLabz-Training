import java.util.*;

// Base class for all vehicles
class Vehicle{
	int maxSpeed; // Better variable name
	String fuelType; // Better variable name
	
	// Constructor to initialize vehicle properties
	Vehicle(int maxSpeed, String fuelType){
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
	}
	
	// Method to display vehicle information
	void Display() {
		System.out.println("Max Speed: " + maxSpeed + " km/h Fuel Type: " + fuelType);
	}
}

// Car class inherits from Vehicle
class Car extends Vehicle{
	int seatCapacity; // Better variable name
	
	// Constructor calls parent constructor and adds seat capacity
	Car(int maxSpeed, String fuelType, int seatCapacity){
		super(maxSpeed, fuelType);
		this.seatCapacity = seatCapacity;
	}
	
	// Override Display to include seat capacity
	void Display() {
		super.Display(); // Call parent method
		System.out.println("Seat Capacity: " + seatCapacity);
	}
}

// Truck class inherits from Vehicle
class Truck extends Vehicle{
	int loadCapacity; // Better variable name
	
	// Constructor calls parent constructor and adds load capacity
	Truck(int maxSpeed, String fuelType, int loadCapacity){
		super(maxSpeed, fuelType);
		this.loadCapacity = loadCapacity;
	}
	
	// Override Display to include load capacity
	void Display() {
		super.Display(); // Call parent method
		System.out.println("Load Capacity: " + loadCapacity + " kg");
	}
}

// Motorcycle class inherits from Vehicle
class Motorcycle extends Vehicle{
	
	// Constructor calls parent constructor
	Motorcycle(int maxSpeed, String fuelType){
		super(maxSpeed, fuelType);
	}
	
	// Uses parent Display method as-is
	void Display() {
		super.Display();
	}
}

// Main class to demonstrate vehicle hierarchy with polymorphism
public class VehicleAndTransportSystem {
	public static void main(String[] args) {
		// Create array of Vehicle references (polymorphism)
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Car(120, "Petrol", 5);
		vehicles[1] = new Truck(80, "Diesel", 500);
		vehicles[2] = new Motorcycle(100, "Petrol");
		
		// Display all vehicles using polymorphism
		for(int i = 0; i < vehicles.length; i++) {
			Vehicle vehicle = vehicles[i];
			vehicle.Display(); // Calls appropriate Display method
			System.out.println();
		}
	}
}
