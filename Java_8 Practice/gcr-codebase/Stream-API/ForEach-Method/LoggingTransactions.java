import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LoggingTransactions {
    
    private static final DateTimeFormatter TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001",
            "TXN002", 
            "TXN003",
            "TXN004",
            "TXN005",
            "TXN006",
            "TXN007",
            "TXN008",
            "TXN009",
            "TXN010"
        );
        
        System.out.println("=== Transaction Logging System ===");
        System.out.println("Session started: " + LocalDateTime.now().format(TIMESTAMP_FORMAT));
        System.out.println("===================================\n");
        
        // Basic transaction logging as specified
        System.out.println("📝 Basic Transaction Logging:");
        transactionIds.forEach(id -> 
            System.out.println(LocalDateTime.now().format(TIMESTAMP_FORMAT) + " - Transaction: " + id));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Enhanced logging with different log levels
        System.out.println("📊 Enhanced Transaction Logging:");
        
        transactionIds.forEach(id -> {
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            String logLevel = getRandomLogLevel();
            String status = getRandomStatus();
            double amount = Math.random() * 10000;
            
            System.out.printf("%s [%s] Transaction: %s | Status: %s | Amount: ₹%.2f%n",
                timestamp, logLevel, id, status, amount);
            
            // Add small delay to show different timestamps
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Categorized logging
        System.out.println("🏷️ Categorized Transaction Logging:");
        
        // Group transactions by type for logging
        Map<String, List<String>> transactionsByType = new HashMap<>();
        transactionsByType.put("PAYMENT", Arrays.asList("TXN001", "TXN003", "TXN005"));
        transactionsByType.put("REFUND", Arrays.asList("TXN002", "TXN006"));
        transactionsByType.put("TRANSFER", Arrays.asList("TXN004", "TXN007", "TXN008"));
        transactionsByType.put("WITHDRAWAL", Arrays.asList("TXN009", "TXN010"));
        
        transactionsByType.forEach((type, transactions) -> {
            System.out.println("\n" + type + " Transactions:");
            transactions.forEach(id -> {
                String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
                System.out.printf("  %s [%s] %s - Processed%n", timestamp, type, id);
                
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        });
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Error simulation logging
        System.out.println("⚠️ Transaction Processing with Error Handling:");
        
        transactionIds.forEach(id -> {
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            
            // Simulate random errors
            if (Math.random() < 0.2) { // 20% error rate
                System.out.printf("%s [ERROR] Transaction: %s - Processing failed: %s%n",
                    timestamp, id, getRandomError());
            } else {
                System.out.printf("%s [INFO] Transaction: %s - Successfully processed%n",
                    timestamp, id);
            }
            
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Summary logging
        System.out.println("\n📈 Transaction Processing Summary:");
        System.out.println("==================================");
        System.out.println("Total transactions processed: " + transactionIds.size());
        System.out.println("Processing completed at: " + LocalDateTime.now().format(TIMESTAMP_FORMAT));
        
        // Audit trail
        System.out.println("\n🔍 Audit Trail:");
        transactionIds.forEach(id -> {
            String auditTimestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            System.out.printf("%s [AUDIT] Transaction %s logged to audit database%n",
                auditTimestamp, id);
        });
        
        System.out.println("\nSession ended: " + LocalDateTime.now().format(TIMESTAMP_FORMAT));
    }
    
    private static String getRandomLogLevel() {
        String[] levels = {"INFO", "DEBUG", "WARN", "ERROR"};
        return levels[new Random().nextInt(levels.length)];
    }
    
    private static String getRandomStatus() {
        String[] statuses = {"SUCCESS", "PENDING", "FAILED", "PROCESSING"};
        return statuses[new Random().nextInt(statuses.length)];
    }
    
    private static String getRandomError() {
        String[] errors = {
            "Insufficient funds",
            "Network timeout",
            "Invalid account",
            "Service unavailable",
            "Authentication failed"
        };
        return errors[new Random().nextInt(errors.length)];
    }
}