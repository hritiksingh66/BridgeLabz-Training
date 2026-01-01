import java.util.*;

// Base class for all vehicles (renamed to avoid conflict)
class VehicleM{
	int maxSpeed; // Better variable name
	String model;
	
	// Constructor to initialize vehicle properties
	VehicleM(int maxSpeed, String model){
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
	
	// Method to display vehicle information
	void Display() {
		System.out.println("Max Speed: " + maxSpeed + " km/h  Model: " + model);
	}
}

// Interface for vehicles that can be refueled
interface Refuelable{
	void refuel(); // Method to refuel vehicle
}

// Electric vehicle class inherits from VehicleM
class ElectricVehicle extends VehicleM{
	
	// Constructor calls parent constructor
	ElectricVehicle(int maxSpeed, String model){
		super(maxSpeed, model);
	}
	
	// Method specific to electric vehicles
	void charge(){
		System.out.println(model + " requires Charging");
	}
	
	// Uses parent Display method
	void Display() {
		super.Display();
	}
}

// Petrol vehicle class inherits from VehicleM and implements Refuelable
class PetrolVehicle extends VehicleM implements Refuelable{
	
	// Constructor calls parent constructor
	PetrolVehicle(int maxSpeed, String model){
		super(maxSpeed, model);
	}
	
	// Implementation of Refuelable interface method
	public void refuel(){
		System.out.println(model + " requires Refueling");
	}
	
	// Uses parent Display method
	void Display() {
		super.Display();
	}
}

// Main class to demonstrate vehicle management with inheritance and interfaces
public class VehicleManagementSystem {
	public static void main(String[] args) {
		// Create different types of vehicles
		ElectricVehicle e1 = new ElectricVehicle(160, "Tesla Model 3");
		PetrolVehicle p1 = new PetrolVehicle(190, "Honda Civic");
		
		// Display vehicle information and demonstrate specific methods
		e1.Display();
		e1.charge(); // Electric vehicle specific method
		
		p1.Display();
		p1.refuel(); // Petrol vehicle specific method (from interface)
	}
}
