import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    private String type;
    private String message;
    private String priority;
    private String department;
    
    public Alert(String type, String message, String priority, String department) {
        this.type = type;
        this.message = message;
        this.priority = priority;
        this.department = department;
    }
    
    // Getters
    public String getType() { return type; }
    public String getMessage() { return message; }
    public String getPriority() { return priority; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s)", priority, type, message, department);
    }
}

public class NotificationFiltering {
    
    // Map to store different filter preferences using Predicate lambdas
    private Map<String, Predicate<Alert>> filterPreferences = new HashMap<>();
    
    public NotificationFiltering() {
        // Define filter preferences using lambda expressions with Predicate
        
        // Emergency only - show only critical alerts
        filterPreferences.put("emergency", alert -> "CRITICAL".equals(alert.getPriority()));
        
        // Department specific - show alerts for specific department
        filterPreferences.put("cardiology", alert -> "Cardiology".equals(alert.getDepartment()));
        
        // High priority - show critical and high priority alerts
        filterPreferences.put("high_priority", alert -> 
            "CRITICAL".equals(alert.getPriority()) || "HIGH".equals(alert.getPriority()));
        
        // Medical only - filter out administrative alerts
        filterPreferences.put("medical_only", alert -> 
            "MEDICAL".equals(alert.getType()) || "EMERGENCY".equals(alert.getType()));
    }
    
    // Filter alerts based on user preference
    public List<Alert> filterAlerts(List<Alert> alerts, String preference) {
        Predicate<Alert> filter = filterPreferences.get(preference);
        if (filter != null) {
            return alerts.stream()
                        .filter(filter)
                        .collect(Collectors.toList());
        }
        return alerts; // Return all if no preference found
    }
    
    public static void main(String[] args) {
        NotificationFiltering hospitalApp = new NotificationFiltering();
        
        // Create sample alerts
        List<Alert> alerts = Arrays.asList(
            new Alert("EMERGENCY", "Patient in room 101 needs immediate attention", "CRITICAL", "Emergency"),
            new Alert("MEDICAL", "Medication reminder for patient 205", "MEDIUM", "Cardiology"),
            new Alert("ADMIN", "Staff meeting at 3 PM", "LOW", "Administration"),
            new Alert("MEDICAL", "Lab results ready for patient 303", "HIGH", "Cardiology"),
            new Alert("EMERGENCY", "Code blue in ICU", "CRITICAL", "ICU"),
            new Alert("ADMIN", "System maintenance tonight", "MEDIUM", "IT")
        );
        
        System.out.println("All Alerts:");
        alerts.forEach(System.out::println);
        System.out.println();
        
        // Test different filter preferences
        System.out.println("Emergency Only:");
        hospitalApp.filterAlerts(alerts, "emergency").forEach(System.out::println);
        System.out.println();
        
        System.out.println("Cardiology Department:");
        hospitalApp.filterAlerts(alerts, "cardiology").forEach(System.out::println);
        System.out.println();
        
        System.out.println("High Priority:");
        hospitalApp.filterAlerts(alerts, "high_priority").forEach(System.out::println);
        System.out.println();
        
        System.out.println("Medical Only:");
        hospitalApp.filterAlerts(alerts, "medical_only").forEach(System.out::println);
    }
}