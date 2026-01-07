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

public class InsurancePolicyMapManager {
    // HashMap for quick lookups
    private HashMap<String, InsurancePolicy> hashMapPolicies;
    // LinkedHashMap maintains insertion order
    private LinkedHashMap<String, InsurancePolicy> linkedHashMapPolicies;
    // TreeMap sorts by expiry date
    private TreeMap<LocalDate, InsurancePolicy> treeMapPolicies;
    
    public InsurancePolicyMapManager() {
        hashMapPolicies = new HashMap<>();
        linkedHashMapPolicies = new LinkedHashMap<>();
        treeMapPolicies = new TreeMap<>();
    }
    
    // Add policy to all three maps
    public void addPolicy(InsurancePolicy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }
    
    // Get policy by policy number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }
    
    // Find policies expiring within 30 days
    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        List<InsurancePolicy> expiringSoon = new ArrayList<>();
        
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.getExpiryDate().isBefore(thirtyDaysFromNow)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    
    // Get all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    
    // Remove all expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMapPolicies.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        linkedHashMapPolicies.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        treeMapPolicies.entrySet().removeIf(entry -> entry.getKey().isBefore(today));
    }
    
    public void displayAllMaps() {
        System.out.println("HashMap policies: " + hashMapPolicies.values());
        System.out.println("LinkedHashMap policies: " + linkedHashMapPolicies.values());
        System.out.println("TreeMap policies (sorted by expiry): " + treeMapPolicies.values());
    }
    
    public static void main(String[] args) {
        InsurancePolicyMapManager manager = new InsurancePolicyMapManager();
        
        manager.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 6, 15), "Health", 1200.0));
        manager.addPolicy(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 3, 10), "Auto", 800.0));
        manager.addPolicy(new InsurancePolicy("P003", "John Doe", LocalDate.of(2024, 8, 20), "Home", 1500.0));
        
        manager.displayAllMaps();
        
        System.out.println("\nPolicy P001: " + manager.getPolicyByNumber("P001"));
        System.out.println("John Doe's policies: " + manager.getPoliciesByPolicyholder("John Doe"));
        System.out.println("Policies expiring soon: " + manager.getPoliciesExpiringSoon());
    }
}