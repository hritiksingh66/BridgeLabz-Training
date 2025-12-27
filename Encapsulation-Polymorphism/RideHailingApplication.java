import java.util.*;

// Abstract base class for transport vehicles - demonstrates encapsulation
abstract class Transport {
    // Private fields - encapsulated data
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor to initialize transport
    Transport(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getter methods for accessing private fields
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Method to get transport details
    public String getTransportDetails() {
        return "Vehicle ID: " + vehicleId + " | Driver: " + driverName + " | Rate per Km: " + ratePerKm;
    }

    // Abstract method - must be implemented by child classes
    public abstract double calculateFare(double distance);
}

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Sedan class extends Transport
class Sedan extends Transport {
    // Constructor calls parent constructor
    public Sedan(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Implementation of abstract method
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

// Motorcycle class extends Transport
class Motorcycle extends Transport {
    // Constructor calls parent constructor
    public Motorcycle(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Implementation of abstract method
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

// Auto class extends Transport
class Auto extends Transport {
    // Constructor calls parent constructor
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    // Implementation of abstract method
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

// GPS implementation class
class GPSImpl implements GPS {
    private String currentLocation;

    // Implementation of interface method
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    // Implementation of interface method
    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Utility class to manage rides - demonstrates polymorphism
class RideManager {
    public static void calculateFareForRide(Transport transport, double distance) {
        System.out.println(transport.getTransportDetails());
        System.out.println("Fare for " + distance + " Km: " + transport.calculateFare(distance));
    }
}

// Main class to demonstrate ride hailing application
public class RideHailingApplication {
    public static void main(String[] args) {
        // Create different transport vehicles
        Transport sedan = new Sedan("S123", "John", 10);
        Transport motorcycle = new Motorcycle("M456", "Mike", 5);
        Transport auto = new Auto("A789", "Alex", 7);

        // Calculate fares using polymorphism
        System.out.println("Calculating fare for Sedan:");
        RideManager.calculateFareForRide(sedan, 15);

        System.out.println("\nCalculating fare for Motorcycle:");
        RideManager.calculateFareForRide(motorcycle, 10);

        System.out.println("\nCalculating fare for Auto:");
        RideManager.calculateFareForRide(auto, 20);

        // Demonstrate GPS functionality
        GPSImpl gps = new GPSImpl();
        gps.updateLocation("Downtown");
        System.out.println("\nCurrent Location: " + gps.getCurrentLocation());
    }
}
