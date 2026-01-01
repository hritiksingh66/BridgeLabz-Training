import java.util.*;

// Base class for all smart home devices
class Device{
	int id;
	String status;
	
	// Constructor to initialize device properties
	Device(int id, String status){
		this.id = id;
		this.status = status;
	}
	
	// Method to display device information
	void Display() {
		System.out.print("Device ID: " + id + " Status: " + status);
	}
}

// Thermostat class inherits from Device
class Thermostat extends Device{
	int temperature; // Better variable name
	
	// Constructor calls parent constructor and adds temperature setting
	Thermostat(int id, String status, int temperature){
		super(id, status);
		this.temperature = temperature;
	}
	
	// Override Display to include temperature information
	void Display() {
		super.Display(); // Call parent method
		System.out.print(" Temperature: " + temperature + "°C");
	}
}

// Main class to demonstrate smart home device hierarchy
public class SmartHomeDevices {
	public static void main(String[] args) {
		// Create different thermostat devices
		Thermostat t1 = new Thermostat(101, "On", 24);
		Thermostat t2 = new Thermostat(102, "Off", 20);
		
		// Display device information
		t1.Display();
		System.out.println();
		
		t2.Display();
		System.out.println();
	}
}
