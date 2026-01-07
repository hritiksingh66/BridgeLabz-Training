import java.time.LocalDate;
import java.util.Objects;

public class InsurancePolicy implements Comparable<InsurancePolicy> {
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
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
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