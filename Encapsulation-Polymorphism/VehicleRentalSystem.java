import java.util.*;

// Abstract base class for vehicles - demonstrates encapsulation
abstract class Vehicle{
	// Private fields - encapsulated data
	private int vehicleNumber; 
	private String type;
	private int rentalRate;
	
	// Constructor to initialize vehicle
	Vehicle(int vehicleNumber, String type, int rentalRate){
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}
	
	// Setter method for vehicle number
	void SetVN(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	// Getter method for vehicle number
	int GetVN() {
		return vehicleNumber;
	}
	
	// Setter method for type
	void SetT(String type) {
		this.type = type;
	}
	
	// Getter method for type
	String GetT() {
		return type;
	}
	
	// Setter method for rental rate
	void SetR(int rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	// Getter method for rental rate
	int GetR() {
		return rentalRate;
	}
	
	// Abstract method - must be implemented by child classes
	abstract int calculateRentalCost(int days);
}

// Interface for insurance functionality
interface Insurable{
	void calculateInsurance();
	int getInsuranceDetails();
}

// Car class extends Vehicle and implements Insurable
class Car extends Vehicle implements Insurable{
	int rentalDays;
	int totalCost;
	int insurancePerDay;
	int totalInsurance;
	
	// Constructor calls parent constructor
	Car(int vehicleNumber, String type, int rentalRate, int rentalDays, int insurancePerDay){
		super(vehicleNumber, type, rentalRate);
		this.rentalDays = rentalDays;
		this.insurancePerDay = insurancePerDay;
	}
	
	// Implementation of abstract method
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	// Implementation of interface method
	public void calculateInsurance() {
		int insurance = insurancePerDay * rentalDays;
		this.totalInsurance = insurance;
	}
	
	// Implementation of interface method
	public int getInsuranceDetails() {
		return totalInsurance;
	}
	
	// Method to display car rental details
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + rentalDays + " | Total Cost: " + calculateRentalCost(rentalDays) +  " | Insurance Cost: " + getInsuranceDetails());
	}
}

// Bike class extends Vehicle and implements Insurable
class Bike extends Vehicle implements Insurable{
	int rentalDays;
	int totalCost;
	int insurancePerDay;
	int totalInsurance;
	
	// Constructor calls parent constructor
	Bike(int vehicleNumber, String type, int rentalRate, int rentalDays, int insurancePerDay){
		super(vehicleNumber, type, rentalRate);
		this.rentalDays = rentalDays;
		this.insurancePerDay = insurancePerDay;
	}
	
	// Implementation of abstract method
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	// Implementation of interface method
	public void calculateInsurance() {
		int insurance = insurancePerDay * rentalDays;
		this.totalInsurance = insurance;
	}
	
	// Implementation of interface method
	public int getInsuranceDetails() {
		return totalInsurance;
	}
	
	// Method to display bike rental details
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + rentalDays + " | Total Cost: " + calculateRentalCost(rentalDays) + " | Insurance Cost: " + getInsuranceDetails());
	}
}

// Truck class extends Vehicle and implements Insurable
class Truck extends Vehicle implements Insurable{
	int rentalDays;
	int totalCost;
	int insurancePerDay;
	int totalInsurance;
	
	// Constructor calls parent constructor
	Truck(int vehicleNumber, String type, int rentalRate, int rentalDays, int insurancePerDay){
		super(vehicleNumber, type, rentalRate);
		this.rentalDays = rentalDays;
		this.insurancePerDay = insurancePerDay;
	}
	
	// Implementation of abstract method
	int calculateRentalCost(int days) {
		int cost = days * GetR();
		return cost;
	}
	
	// Implementation of interface method
	public void calculateInsurance() {
		int insurance = insurancePerDay * rentalDays;
		this.totalInsurance = insurance;
	}
	
	// Implementation of interface method
	public int getInsuranceDetails() {
		return totalInsurance;
	}
	
	// Method to display truck rental details
	void Display() {
		System.out.println("Vehicle Number: " + GetVN() + " | Type: " + GetT() + " | Rental Rate (per Day): " + GetR() + " | Rental Days: " + rentalDays  + " | Total Cost: " + calculateRentalCost(rentalDays) +   " | Insurance Cost: " + getInsuranceDetails());
	}
}

// Main class to demonstrate vehicle rental system
public class VehicleRentalSystem {
	public static void main(String[] args) {     
		// Create different vehicle types
		Car c = new Car(2001, "Car", 1500, 3, 100);         
		Bike b = new Bike(3001, "Bike", 500, 2, 50);
		Truck t = new Truck(1001, "Truck", 3000, 4, 200);
		
		// Calculate insurance and display details for each vehicle
		c.calculateInsurance();
		c.Display();
		
		b.calculateInsurance();
		b.Display();
		
		t.calculateInsurance();
		t.Display();
	}
}
