// Custom marker interface for sensitive data
interface SensitiveData {
    // Marker interface - no methods
}

// Customer data marked as sensitive
class CustomerData implements SensitiveData {
    private String customerId;
    private String name;
    private String phoneNumber;
    private String address;
    
    public CustomerData(String customerId, String name, String phoneNumber, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "CustomerData{customerId='" + customerId + "', name='" + name + 
               "', phone='" + phoneNumber + "', address='" + address + "'}";
    }
}

// Financial data marked as sensitive
class FinancialRecord implements SensitiveData {
    private String accountNumber;
    private double balance;
    private String bankName;
    
    public FinancialRecord(String accountNumber, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankName = bankName;
    }
    
    @Override
    public String toString() {
        return "FinancialRecord{accountNumber='" + accountNumber + 
               "', balance=" + balance + ", bankName='" + bankName + "'}";
    }
}

// Medical record marked as sensitive
class MedicalRecord implements SensitiveData {
    private String patientId;
    private String diagnosis;
    private String medication;
    
    public MedicalRecord(String patientId, String diagnosis, String medication) {
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.medication = medication;
    }
    
    @Override
    public String toString() {
        return "MedicalRecord{patientId='" + patientId + 
               "', diagnosis='" + diagnosis + "', medication='" + medication + "'}";
    }
}

// Regular data class (not sensitive)
class ProductCatalog {
    private String productId;
    private String productName;
    private double price;
    
    public ProductCatalog(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "ProductCatalog{productId='" + productId + 
               "', productName='" + productName + "', price=" + price + "}";
    }
}

// Encryption processor
class EncryptionProcessor {
    
    public static void processData(Object data) {
        if (data instanceof SensitiveData) {
            System.out.println("🔒 SENSITIVE DATA DETECTED - Applying encryption");
            encryptData(data);
        } else {
            System.out.println("📄 Regular data - No encryption needed");
            System.out.println("   Stored as: " + data);
        }
        System.out.println();
    }
    
    private static void encryptData(Object data) {
        // Simulate encryption process
        String originalData = data.toString();
        String encryptedData = encrypt(originalData);
        
        System.out.println("   Original: " + originalData);
        System.out.println("   Encrypted: " + encryptedData);
        System.out.println("   ✅ Data encrypted and stored securely");
    }
    
    private static String encrypt(String data) {
        // Simple encryption simulation (not for production use)
        StringBuilder encrypted = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                encrypted.append("*");
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
    
    public static void auditSensitiveData(Object[] dataObjects) {
        System.out.println("=== Sensitive Data Audit ===");
        int sensitiveCount = 0;
        int totalCount = dataObjects.length;
        
        for (Object data : dataObjects) {
            if (data instanceof SensitiveData) {
                sensitiveCount++;
                System.out.println("🔒 " + data.getClass().getSimpleName() + " - SENSITIVE");
            } else {
                System.out.println("📄 " + data.getClass().getSimpleName() + " - Regular");
            }
        }
        
        System.out.println("\nAudit Summary:");
        System.out.println("Total objects: " + totalCount);
        System.out.println("Sensitive objects: " + sensitiveCount);
        System.out.println("Regular objects: " + (totalCount - sensitiveCount));
        System.out.println();
    }
}

public class SensitiveDataTagging {
    
    public static void main(String[] args) {
        System.out.println("=== Sensitive Data Processing System ===\n");
        
        Object[] dataObjects = {
            new CustomerData("CUST001", "John Doe", "+91-9876543210", "123 Main St, Mumbai"),
            new FinancialRecord("ACC123456789", 50000.0, "HDFC Bank"),
            new ProductCatalog("PROD001", "Laptop", 45000.0),
            new MedicalRecord("PAT001", "Hypertension", "Amlodipine 5mg"),
            new ProductCatalog("PROD002", "Mouse", 500.0)
        };
        
        // Process each data object
        for (Object data : dataObjects) {
            System.out.println("Processing: " + data.getClass().getSimpleName());
            EncryptionProcessor.processData(data);
        }
        
        // Audit sensitive data
        EncryptionProcessor.auditSensitiveData(dataObjects);
    }
}