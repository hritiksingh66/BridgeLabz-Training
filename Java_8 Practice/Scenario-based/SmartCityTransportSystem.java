import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;

// Marker Interface - for emergency services
interface EmergencyService {
    // Marker interface - no methods
}

// Interface with static method for distance calculation
interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2)) * 100;
    }
}

// Functional Interface for fare calculation
@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, boolean isPeakTime);
}

// Main Transport Service Interface with default and abstract methods
interface TransportService {
    String getServiceName();
    String getRoute();
    LocalTime getDepartureTime();
    double getFare();
    
    // Default method - can be overridden
    default void printServiceDetails() {
        System.out.println("Service: " + getServiceName() + " | Route: " + getRoute() + 
                         " | Departure: " + getDepartureTime() + " | Fare: $" + getFare());
    }
}

// Trip class for passenger data
class Trip {
    private String passengerName;
    private String route;
    private double fare;
    private boolean isPeakTime;
    
    public Trip(String passengerName, String route, double fare, boolean isPeakTime) {
        this.passengerName = passengerName;
        this.route = route;
        this.fare = fare;
        this.isPeakTime = isPeakTime;
    }
    
    public String getPassengerName() { return passengerName; }
    public String getRoute() { return route; }
    public double getFare() { return fare; }
    public boolean isPeakTime() { return isPeakTime; }
}

// Bus Service Implementation
class BusService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    
    public BusService(String route, LocalTime departureTime, double fare) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
    }
    
    @Override
    public String getServiceName() { return "Bus"; }
    @Override
    public String getRoute() { return route; }
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    @Override
    public double getFare() { return fare; }
}

// Metro Service Implementation
class MetroService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    
    public MetroService(String route, LocalTime departureTime, double fare) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
    }
    
    @Override
    public String getServiceName() { return "Metro"; }
    @Override
    public String getRoute() { return route; }
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    @Override
    public double getFare() { return fare; }
}

// Taxi Service Implementation
class TaxiService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    
    public TaxiService(String route, LocalTime departureTime, double fare) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
    }
    
    @Override
    public String getServiceName() { return "Taxi"; }
    @Override
    public String getRoute() { return route; }
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    @Override
    public double getFare() { return fare; }
}

// Ambulance Service - implements EmergencyService marker interface
class AmbulanceService implements TransportService, EmergencyService {
    private String route;
    private LocalTime departureTime;
    
    public AmbulanceService(String route, LocalTime departureTime) {
        this.route = route;
        this.departureTime = departureTime;
    }
    
    @Override
    public String getServiceName() { return "Ambulance"; }
    @Override
    public String getRoute() { return route; }
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    @Override
    public double getFare() { return 0.0; }
    
    @Override
    public void printServiceDetails() {
        System.out.println("[EMERGENCY] " + getServiceName() + " | Route: " + getRoute() + 
                         " | Departure: " + getDepartureTime() + " | Priority Access");
    }
}

class SmartCityTransportSystem {
    public static void main(String[] args) {
        System.out.println("=== Smart City Transport & Service Management System ===\n");
        
        // Create transport services
        List<TransportService> services = Arrays.asList(
            new BusService("Route-A", LocalTime.of(8, 30), 2.5),
            new MetroService("Route-B", LocalTime.of(8, 15), 3.0),
            new TaxiService("Route-A", LocalTime.of(8, 45), 15.0),
            new BusService("Route-C", LocalTime.of(9, 0), 2.0),
            new MetroService("Route-A", LocalTime.of(8, 0), 3.5),
            new AmbulanceService("Route-Emergency", LocalTime.of(8, 20))
        );
        
        // 1. Lambda Expression - Filter and sort by earliest departure and lowest fare
        System.out.println("1. FILTERED SERVICES (Route-A, sorted by departure time):");
        services.stream()
            .filter(s -> s.getRoute().equals("Route-A"))
            .sorted((s1, s2) -> s1.getDepartureTime().compareTo(s2.getDepartureTime()))
            .forEach(TransportService::printServiceDetails);
        
        // 2. Method Reference - Print all services
        System.out.println("\n2. ALL AVAILABLE SERVICES (using method reference):");
        services.forEach(TransportService::printServiceDetails);
        
        // 3. Static Method in Interface - Calculate distance
        System.out.println("\n3. DISTANCE CALCULATION (using static interface method):");
        double distance = GeoUtils.calculateDistance(40.7128, -74.0060, 40.7580, -73.9855);
        System.out.println("Distance between locations: " + String.format("%.2f", distance) + " km");
        
        // 4. Functional Interface - Fare calculation using lambda
        System.out.println("\n4. DYNAMIC FARE CALCULATION (using functional interface):");
        FareCalculator fareCalc = (dist, isPeak) -> dist * (isPeak ? 1.5 : 1.0);
        System.out.println("Fare for 10km (peak): $" + fareCalc.calculateFare(10, true));
        System.out.println("Fare for 10km (non-peak): $" + fareCalc.calculateFare(10, false));
        
        // 5. Marker Interface - Detect emergency services
        System.out.println("\n5. EMERGENCY SERVICES DETECTION (using marker interface):");
        services.stream()
            .filter(s -> s instanceof EmergencyService)
            .forEach(s -> System.out.println("Emergency service detected: " + s.getServiceName()));
        
        // Create passenger trip data
        List<Trip> trips = Arrays.asList(
            new Trip("Alice", "Route-A", 2.5, true),
            new Trip("Bob", "Route-B", 3.0, false),
            new Trip("Charlie", "Route-A", 15.0, true),
            new Trip("David", "Route-C", 2.0, false),
            new Trip("Eve", "Route-A", 3.5, true),
            new Trip("Frank", "Route-B", 3.0, true)
        );
        
        // 6. Stream API with Collectors - Group passengers by route
        System.out.println("\n6. PASSENGERS GROUPED BY ROUTE (using groupingBy):");
        Map<String, List<Trip>> tripsByRoute = trips.stream()
            .collect(Collectors.groupingBy(Trip::getRoute));
        tripsByRoute.forEach((route, tripList) -> 
            System.out.println(route + ": " + tripList.size() + " passengers"));
        
        // 7. Collectors - Partition by peak time
        System.out.println("\n7. TRIPS PARTITIONED BY PEAK TIME (using partitioningBy):");
        Map<Boolean, List<Trip>> tripsByPeakTime = trips.stream()
            .collect(Collectors.partitioningBy(Trip::isPeakTime));
        System.out.println("Peak time trips: " + tripsByPeakTime.get(true).size());
        System.out.println("Non-peak trips: " + tripsByPeakTime.get(false).size());
        
        // 8. Collectors - Summarize fare statistics
        System.out.println("\n8. REVENUE STATISTICS (using summarizingDouble):");
        DoubleSummaryStatistics fareStats = trips.stream()
            .collect(Collectors.summarizingDouble(Trip::getFare));
        System.out.println("Total Revenue: $" + fareStats.getSum());
        System.out.println("Average Fare: $" + String.format("%.2f", fareStats.getAverage()));
        System.out.println("Max Fare: $" + fareStats.getMax());
        System.out.println("Min Fare: $" + fareStats.getMin());
        
        // 9. Stream API - Find top routes by usage
        System.out.println("\n9. TOP ROUTES BY USAGE:");
        tripsByRoute.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue().size() + " trips"));
        
        // 10. ForEach - Live dashboard display
        System.out.println("\n10. LIVE DASHBOARD - ACTIVE SERVICES:");
        services.stream()
            .filter(s -> s.getDepartureTime().isAfter(LocalTime.now().minusHours(2)))
            .forEach(TransportService::printServiceDetails);
        
        System.out.println("\n=== System Ready for Real-Time Operations ===");
    }
}
