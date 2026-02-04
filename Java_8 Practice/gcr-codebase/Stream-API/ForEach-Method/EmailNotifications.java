import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EmailNotifications {
    
    // Simulate email sending
    private static void sendEmailNotification(String email) {
        System.out.println("📧 Sending notification to: " + email);
        System.out.println("   Subject: Important System Update");
        System.out.println("   Status: Delivered ✅");
        System.out.println("   Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println();
    }
    
    // Enhanced email sending with message type
    private static void sendEmailNotification(String email, String messageType) {
        String subject = getSubjectByType(messageType);
        String status = Math.random() > 0.1 ? "Delivered ✅" : "Failed ❌";
        
        System.out.println("📧 " + messageType.toUpperCase() + " notification to: " + email);
        System.out.println("   Subject: " + subject);
        System.out.println("   Status: " + status);
        System.out.println("   Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println();
    }
    
    private static String getSubjectByType(String messageType) {
        return switch (messageType.toLowerCase()) {
            case "welcome" -> "Welcome to Our Platform!";
            case "security" -> "Security Alert - Action Required";
            case "promotion" -> "Special Offer Just for You!";
            case "reminder" -> "Friendly Reminder";
            case "update" -> "Important System Update";
            default -> "Notification";
        };
    }
    
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
            "john.doe@example.com",
            "jane.smith@company.com",
            "mike.johnson@email.com",
            "sarah.wilson@domain.com",
            "david.brown@test.com",
            "lisa.davis@sample.org",
            "tom.miller@demo.net",
            "amy.taylor@example.org"
        );
        
        System.out.println("=== Email Notification System ===");
        System.out.println("Total recipients: " + emails.size());
        System.out.println("Start time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("===================================\n");
        
        // Basic forEach - send notification to each user
        System.out.println("📤 Sending basic notifications:");
        emails.forEach(email -> sendEmailNotification(email));
        
        System.out.println("=====================================\n");
        
        // Different types of notifications
        System.out.println("📤 Sending welcome emails to new users:");
        emails.stream()
            .filter(email -> email.contains("example"))
            .forEach(email -> sendEmailNotification(email, "welcome"));
        
        System.out.println("📤 Sending security alerts to company emails:");
        emails.stream()
            .filter(email -> email.contains("company"))
            .forEach(email -> sendEmailNotification(email, "security"));
        
        System.out.println("📤 Sending promotional emails:");
        emails.stream()
            .filter(email -> !email.contains("company"))
            .forEach(email -> sendEmailNotification(email, "promotion"));
        
        // Batch processing with status tracking
        System.out.println("📊 Batch Email Processing Summary:");
        System.out.println("=====================================");
        
        List<String> successfulEmails = new ArrayList<>();
        List<String> failedEmails = new ArrayList<>();
        
        emails.forEach(email -> {
            try {
                // Simulate email sending with random success/failure
                if (Math.random() > 0.15) { // 85% success rate
                    successfulEmails.add(email);
                    System.out.println("✅ SUCCESS: " + email);
                } else {
                    failedEmails.add(email);
                    System.out.println("❌ FAILED: " + email + " (Server timeout)");
                }
            } catch (Exception e) {
                failedEmails.add(email);
                System.out.println("❌ ERROR: " + email + " (" + e.getMessage() + ")");
            }
        });
        
        // Final statistics
        System.out.println("\n📈 Email Campaign Statistics:");
        System.out.println("==============================");
        System.out.println("Total emails: " + emails.size());
        System.out.println("Successful: " + successfulEmails.size());
        System.out.println("Failed: " + failedEmails.size());
        System.out.printf("Success rate: %.1f%%%n", (successfulEmails.size() * 100.0) / emails.size());
        
        if (!failedEmails.isEmpty()) {
            System.out.println("\n🔄 Retry Queue:");
            failedEmails.forEach(email -> 
                System.out.println("   📧 " + email + " - Scheduled for retry"));
        }
        
        System.out.println("\nCampaign completed at: " + 
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}