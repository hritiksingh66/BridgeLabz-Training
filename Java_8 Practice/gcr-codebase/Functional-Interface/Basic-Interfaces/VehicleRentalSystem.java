// Vehicle Rental Interface
interface Rentable {
    void rent(String customerName);
    void returnVehicle();
}

// Car implementation
class Car implements Rentable {
    private String model;
    private boolean isRented = false;
    
    public Car(String model) {
        this.model = model;
    }
    
    @Override
    public void rent(String customerName) {
        if (!isRented) {
            isRented = true;
            System.out.println("Car " + model + " rented to " + customerName);
        } else {
            System.out.println("Car " + model + " is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Car " + model + " returned successfully");
        } else {
            System.out.println("Car " + model + " was not rented");
        }
    }
}

// Bike implementation
class Bike implements Rentable {
    private String type;
    private boolean isRented = false;
    
    public Bike(String type) {
        this.type = type;
    }
    
    @Override
    public void rent(String customerName) {
        if (!isRented) {
            isRented = true;
            System.out.println("Bike " + type + " rented to " + customerName);
        } else {
            System.out.println("Bike " + type + " is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bike " + type + " returned successfully");
        } else {
            System.out.println("Bike " + type + " was not rented");
        }
    }
}

// Bus implementation
class Bus implements Rentable {
    private int capacity;
    private boolean isRented = false;
    
    public Bus(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public void rent(String customerName) {
        if (!isRented) {
            isRented = true;
            System.out.println("Bus (capacity: " + capacity + ") rented to " + customerName);
        } else {
            System.out.println("Bus is already rented");
        }
    }
    
    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println("Bus returned successfully");
        } else {
            System.out.println("Bus was not rented");
        }
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Rentable[] vehicles = {
            new Car("Honda Civic"),
            new Bike("Mountain Bike"),
            new Bus(50)
        };
        
        // Rent vehicles
        vehicles[0].rent("John");
        vehicles[1].rent("Alice");
        vehicles[2].rent("Company XYZ");
        
        System.out.println();
        
        // Return vehicles
        for (Rentable vehicle : vehicles) {
            vehicle.returnVehicle();
        }
    }
}