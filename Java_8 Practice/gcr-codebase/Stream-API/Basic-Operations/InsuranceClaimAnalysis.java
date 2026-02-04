import java.util.*;
import java.util.stream.Collectors;

class InsuranceClaim {
    private String claimId;
    private String claimType;
    private double amount;
    private String status;
    
    public InsuranceClaim(String claimId, String claimType, double amount, String status) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.amount = amount;
        this.status = status;
    }
    
    public String getClaimId() { return claimId; }
    public String getClaimType() { return claimType; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    
    @Override
    public String toString() {
        return String.format("%s - %s: ₹%.2f (%s)", claimId, claimType, amount, status);
    }
}

public class InsuranceClaimAnalysis {
    
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("CLM001", "Health", 15000.0, "Approved"),
            new InsuranceClaim("CLM002", "Auto", 25000.0, "Approved"),
            new InsuranceClaim("CLM003", "Health", 8000.0, "Approved"),
            new InsuranceClaim("CLM004", "Home", 50000.0, "Pending"),
            new InsuranceClaim("CLM005", "Auto", 12000.0, "Approved"),
            new InsuranceClaim("CLM006", "Health", 22000.0, "Rejected"),
            new InsuranceClaim("CLM007", "Home", 35000.0, "Approved"),
            new InsuranceClaim("CLM008", "Auto", 18000.0, "Approved"),
            new InsuranceClaim("CLM009", "Health", 9500.0, "Approved"),
            new InsuranceClaim("CLM010", "Life", 100000.0, "Approved")
        );
        
        System.out.println("=== Insurance Claim Analysis ===\n");
        
        // Average claim amount by claim type
        Map<String, Double> avgByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.averagingDouble(InsuranceClaim::getAmount)
            ));
        
        System.out.println("Average Claim Amount by Type:");
        avgByType.forEach((type, avg) -> 
            System.out.printf("%-10s: ₹%,.2f%n", type, avg));
        
        System.out.println("\n=== Additional Analysis ===");
        
        // Average by status
        Map<String, Double> avgByStatus = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getStatus,
                Collectors.averagingDouble(InsuranceClaim::getAmount)
            ));
        
        System.out.println("\nAverage Claim Amount by Status:");
        avgByStatus.forEach((status, avg) -> 
            System.out.printf("%-10s: ₹%,.2f%n", status, avg));
        
        // Count by type
        Map<String, Long> countByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.counting()
            ));
        
        System.out.println("\nClaim Count by Type:");
        countByType.forEach((type, count) -> 
            System.out.printf("%-10s: %d claims%n", type, count));
        
        // Total amount by type
        Map<String, Double> totalByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.summingDouble(InsuranceClaim::getAmount)
            ));
        
        System.out.println("\nTotal Claim Amount by Type:");
        totalByType.forEach((type, total) -> 
            System.out.printf("%-10s: ₹%,.2f%n", type, total));
    }
}