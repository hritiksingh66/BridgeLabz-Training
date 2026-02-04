import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class GymMember {
    private String name;
    private String memberId;
    private LocalDate expiryDate;
    private String membershipType;
    
    public GymMember(String name, String memberId, LocalDate expiryDate, String membershipType) {
        this.name = name;
        this.memberId = memberId;
        this.expiryDate = expiryDate;
        this.membershipType = membershipType;
    }
    
    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getMembershipType() { return membershipType; }
    
    public long getDaysUntilExpiry() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }
    
    @Override
    public String toString() {
        long daysLeft = getDaysUntilExpiry();
        return String.format("%s (%s) - %s expires in %d days", 
                           name, memberId, membershipType, daysLeft);
    }
}

public class FilteringExpiringMemberships {
    
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        
        List<GymMember> members = Arrays.asList(
            new GymMember("John Doe", "GM001", today.plusDays(15), "Premium"),
            new GymMember("Jane Smith", "GM002", today.plusDays(45), "Basic"),
            new GymMember("Mike Johnson", "GM003", today.plusDays(5), "Premium"),
            new GymMember("Sarah Wilson", "GM004", today.plusDays(60), "Standard"),
            new GymMember("David Brown", "GM005", today.plusDays(25), "Basic"),
            new GymMember("Lisa Davis", "GM006", today.plusDays(2), "Premium"),
            new GymMember("Tom Miller", "GM007", today.plusDays(35), "Standard"),
            new GymMember("Amy Taylor", "GM008", today.plusDays(10), "Basic"),
            new GymMember("Chris Anderson", "GM009", today.plusDays(50), "Premium"),
            new GymMember("Emma Moore", "GM010", today.plusDays(28), "Standard")
        );
        
        System.out.println("=== Gym Membership Expiry Analysis ===\n");
        
        // Filter memberships expiring within 30 days
        List<GymMember> expiringMembers = members.stream()
            .filter(member -> member.getDaysUntilExpiry() <= 30 && member.getDaysUntilExpiry() >= 0)
            .sorted(Comparator.comparing(GymMember::getExpiryDate))
            .collect(Collectors.toList());
        
        System.out.println("Members with expiring memberships (within 30 days):");
        expiringMembers.forEach(System.out::println);
        
        System.out.println("\n=== Urgency Categories ===");
        
        // Critical (expires within 7 days)
        List<GymMember> critical = members.stream()
            .filter(member -> member.getDaysUntilExpiry() <= 7 && member.getDaysUntilExpiry() >= 0)
            .collect(Collectors.toList());
        
        System.out.println("\n🚨 CRITICAL - Expires within 7 days:");
        critical.forEach(member -> System.out.println("  " + member));
        
        // Warning (expires within 8-30 days)
        List<GymMember> warning = members.stream()
            .filter(member -> member.getDaysUntilExpiry() > 7 && member.getDaysUntilExpiry() <= 30)
            .collect(Collectors.toList());
        
        System.out.println("\n⚠️ WARNING - Expires within 8-30 days:");
        warning.forEach(member -> System.out.println("  " + member));
        
        // Summary statistics
        System.out.println("\n=== Summary ===");
        System.out.println("Total members: " + members.size());
        System.out.println("Expiring within 30 days: " + expiringMembers.size());
        System.out.println("Critical (≤7 days): " + critical.size());
        System.out.println("Warning (8-30 days): " + warning.size());
        
        // Group by membership type
        Map<String, Long> expiringByType = expiringMembers.stream()
            .collect(Collectors.groupingBy(
                GymMember::getMembershipType,
                Collectors.counting()
            ));
        
        System.out.println("\nExpiring memberships by type:");
        expiringByType.forEach((type, count) -> 
            System.out.println("  " + type + ": " + count));
    }
}