// Find starting petrol pump to complete circular tour
public class CircularTourProblem {
    
    // Represents a petrol pump with petrol amount and distance to next pump
    static class PetrolPump {
        int petrol;   // Amount of petrol at this pump
        int distance; // Distance to next pump
        
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    
    // Find starting pump index to complete circular tour, return -1 if impossible
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;          // Potential starting point
        int currentPetrol = 0;  // Current petrol in tank
        int totalPetrol = 0;    // Total petrol available
        int totalDistance = 0;  // Total distance to cover
        
        for (int i = 0; i < n; i++) {
            totalPetrol += pumps[i].petrol;
            totalDistance += pumps[i].distance;
            currentPetrol += pumps[i].petrol - pumps[i].distance;
            
            // If we run out of petrol, start from next pump
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        
        // Return start point if tour is possible, else -1
        return (totalPetrol >= totalDistance) ? start : -1;
    }
    
    // Test the circular tour algorithm
    public static void main(String[] args) {
        // Create test pumps: {petrol, distance}
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),  // Pump 0: 4 petrol, 6 distance
            new PetrolPump(6, 5),  // Pump 1: 6 petrol, 5 distance
            new PetrolPump(7, 3),  // Pump 2: 7 petrol, 3 distance
            new PetrolPump(4, 5)   // Pump 3: 4 petrol, 5 distance
        };
        
        int startPoint = findStartingPoint(pumps);
        
        if (startPoint == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Starting point: " + startPoint);
        }
    }
}