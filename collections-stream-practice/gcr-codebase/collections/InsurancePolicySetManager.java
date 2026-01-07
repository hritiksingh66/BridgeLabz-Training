import java.time.LocalDate;
import java.util.*;

// Insurance Policy class with comparable implementation
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    
    public InsurancePolicy(String policyNumber, String policyholderName, 
                          LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }
    
    // Equality based on policy number only
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return java.util.Objects.equals(policyNumber, policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(policyNumber);
    }
    
    // Sort by expiry date for TreeSet
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]", 
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicySetManager {
    // HashSet for quick lookups
    private HashSet<InsurancePolicy> hashSetPolicies;
    // LinkedHashSet maintains insertion order
    private LinkedHashSet<InsurancePolicy> linkedHashSetPolicies;
    // TreeSet sorts by expiry date
    private TreeSet<InsurancePolicy> treeSetPolicies;
    
    public InsurancePolicySetManager() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>();
    }
    
    // Add policy to all three sets
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    
    // Find policies expiring within 30 days
    public Set<InsurancePolicy> getPoliciesExpiringSoon() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        Set<InsurancePolicy> expiringSoon = new HashSet<>();
        
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getExpiryDate().isBefore(thirtyDaysFromNow)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    
    // Filter policies by coverage type
    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePolicy> filtered = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equals(coverageType)) {
                filtered.add(policy);
            }
        }
        return filtered;
    }
    
    public void displayAllSets() {
        System.out.println("HashSet (Quick lookup): " + hashSetPolicies);
        System.out.println("LinkedHashSet (Insertion order): " + linkedHashSetPolicies);
        System.out.println("TreeSet (Sorted by expiry): " + treeSetPolicies);
    }
    
    public static void main(String[] args) {
        InsurancePolicySetManager manager = new InsurancePolicySetManager();
        
        manager.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 6, 15), "Health", 1200.0));
        manager.addPolicy(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 3, 10), "Auto", 800.0));
        manager.addPolicy(new InsurancePolicy("P003", "Bob Johnson", LocalDate.of(2024, 8, 20), "Home", 1500.0));
        
        manager.displayAllSets();
        
        System.out.println("\nPolicies expiring soon:");
        System.out.println(manager.getPoliciesExpiringSoon());
        
        System.out.println("\nHealth policies:");
        System.out.println(manager.getPoliciesByCoverageType("Health"));
    }
}