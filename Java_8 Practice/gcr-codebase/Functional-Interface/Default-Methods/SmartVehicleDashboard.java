// Vehicle dashboard interface
interface VehicleDashboard {
    void displaySpeed();
    
    // Default method for electric vehicles - added later
    default void displayBatteryPercentage() {
        System.out.println("Battery feature not available for this vehicle type");
    }
    
    // Default method for fuel efficiency
    default void displayFuelEfficiency() {
        System.out.println("Fuel efficiency: Standard monitoring");
    }
    
    // Default method for maintenance alerts
    default void displayMaintenanceAlert() {
        System.out.println("Next service: Check vehicle manual");
    }
}

// Regular car (old implementation)
class RegularCar implements VehicleDashboard {
    private int speed;
    private String model;
    
    public RegularCar(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }
    
    @Override
    public void displaySpeed() {
        System.out.println(model + " - Current Speed: " + speed + " km/h");
    }
    
    @Override
    public void displayFuelEfficiency() {
        System.out.println(model + " - Fuel Efficiency: 15 km/l");
    }
}

// Electric car (new implementation with battery feature)
class ElectricCar implements VehicleDashboard {
    private int speed;
    private int batteryPercentage;
    private String model;
    
    public ElectricCar(String model, int speed, int batteryPercentage) {
        this.model = model;
        this.speed = speed;
        this.batteryPercentage = batteryPercentage;
    }
    
    @Override
    public void displaySpeed() {
        System.out.println(model + " - Current Speed: " + speed + " km/h (Electric Mode)");
    }
    
    @Override
    public void displayBatteryPercentage() {
        System.out.println(model + " - Battery: " + batteryPercentage + "%");
        if (batteryPercentage < 20) {
            System.out.println("⚠️ Low battery warning!");
        }
    }
    
    @Override
    public void displayFuelEfficiency() {
        System.out.println(model + " - Energy Efficiency: 120 km per charge");
    }
    
    @Override
    public void displayMaintenanceAlert() {
        System.out.println(model + " - Next service: Battery check in 5000 km");
    }
}

// Hybrid car (uses both features)
class HybridCar implements VehicleDashboard {
    private int speed;
    private int batteryPercentage;
    private String model;
    
    public HybridCar(String model, int speed, int batteryPercentage) {
        this.model = model;
        this.speed = speed;
        this.batteryPercentage = batteryPercentage;
    }
    
    @Override
    public void displaySpeed() {
        System.out.println(model + " - Current Speed: " + speed + " km/h (Hybrid Mode)");
    }
    
    @Override
    public void displayBatteryPercentage() {
        System.out.println(model + " - Electric Battery: " + batteryPercentage + "%");
    }
    
    @Override
    public void displayFuelEfficiency() {
        System.out.println(model + " - Combined Efficiency: 25 km/l + Electric assist");
    }
}

public class SmartVehicleDashboard {
    
    public static void displayDashboard(VehicleDashboard vehicle, String vehicleType) {
        System.out.println("=== " + vehicleType + " Dashboard ===");
        vehicle.displaySpeed();
        vehicle.displayBatteryPercentage();
        vehicle.displayFuelEfficiency();
        vehicle.displayMaintenanceAlert();
        System.out.println();
    }
    
    public static void main(String[] args) {
        VehicleDashboard[] vehicles = {
            new RegularCar("Honda Civic", 80),
            new ElectricCar("Tesla Model 3", 100, 85),
            new HybridCar("Toyota Prius", 70, 60)
        };
        
        String[] vehicleTypes = {"Regular Car", "Electric Car", "Hybrid Car"};
        
        for (int i = 0; i < vehicles.length; i++) {
            displayDashboard(vehicles[i], vehicleTypes[i]);
        }
    }
}