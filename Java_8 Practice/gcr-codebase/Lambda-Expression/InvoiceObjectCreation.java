import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;
    private double amount;
    private String date;
    private String status;
    
    // Constructor for creating invoice from transaction ID
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
        // Simulate generating invoice details based on transaction ID
        this.amount = generateAmount(transactionId);
        this.date = generateDate();
        this.status = "PENDING";
    }
    
    // Constructor with all parameters
    public Invoice(String transactionId, double amount, String date, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }
    
    // Helper methods to simulate data generation
    private double generateAmount(String transactionId) {
        // Simple hash-based amount generation for demo
        return Math.abs(transactionId.hashCode() % 10000) / 100.0;
    }
    
    private String generateDate() {
        return "2024-01-" + String.format("%02d", (int)(Math.random() * 28) + 1);
    }
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    
    @Override
    public String toString() {
        return String.format("Invoice{id='%s', amount=%.2f, date='%s', status='%s'}", 
                           transactionId, amount, date, status);
    }
}

public class InvoiceObjectCreation {
    
    public static void main(String[] args) {
        // List of transaction IDs
        List<String> transactionIds = Arrays.asList(
            "TXN001", "TXN002", "TXN003", "TXN004", "TXN005"
        );
        
        System.out.println("=== Creating Invoices using Constructor Reference ===");
        
        // Using constructor reference instead of lambda
        // Instead of: .map(id -> new Invoice(id))
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)  // Constructor reference
                .collect(Collectors.toList());
        
        invoices.forEach(System.out::println);
        
        System.out.println("\n=== Using Function with Constructor Reference ===");
        
        // Create a Function using constructor reference
        Function<String, Invoice> invoiceCreator = Invoice::new;
        
        // Use the function to create invoices
        List<Invoice> moreInvoices = transactionIds.stream()
                .map(invoiceCreator)  // Using the function
                .collect(Collectors.toList());
        
        System.out.println("Created " + moreInvoices.size() + " invoices:");
        moreInvoices.forEach(System.out::println);
        
        System.out.println("\n=== Batch Invoice Processing ===");
        
        // Simulate batch processing with different transaction types
        Map<String, List<String>> transactionsByType = Map.of(
            "ONLINE", Arrays.asList("ON001", "ON002", "ON003"),
            "STORE", Arrays.asList("ST001", "ST002"),
            "MOBILE", Arrays.asList("MB001", "MB002", "MB003", "MB004")
        );
        
        // Process each type and create invoices
        transactionsByType.forEach((type, ids) -> {
            System.out.println("\n" + type + " Transactions:");
            List<Invoice> typeInvoices = ids.stream()
                    .map(Invoice::new)  // Constructor reference
                    .collect(Collectors.toList());
            
            typeInvoices.forEach(System.out::println);
            
            double totalAmount = typeInvoices.stream()
                    .mapToDouble(Invoice::getAmount)  // Method reference
                    .sum();
            
            System.out.println("Total Amount for " + type + ": $" + String.format("%.2f", totalAmount));
        });
    }
}