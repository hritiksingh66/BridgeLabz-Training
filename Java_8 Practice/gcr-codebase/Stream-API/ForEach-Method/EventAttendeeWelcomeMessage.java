import java.util.*;

class Attendee {
    private String name;
    private String email;
    private String ticketType;
    private boolean isVip;
    
    public Attendee(String name, String email, String ticketType, boolean isVip) {
        this.name = name;
        this.email = email;
        this.ticketType = ticketType;
        this.isVip = isVip;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getTicketType() { return ticketType; }
    public boolean isVip() { return isVip; }
}

public class EventAttendeeWelcomeMessage {
    
    public static void main(String[] args) {
        List<Attendee> attendees = Arrays.asList(
            new Attendee("John Doe", "john@example.com", "Regular", false),
            new Attendee("Jane Smith", "jane@example.com", "VIP", true),
            new Attendee("Mike Johnson", "mike@example.com", "Premium", false),
            new Attendee("Sarah Wilson", "sarah@example.com", "VIP", true),
            new Attendee("David Brown", "david@example.com", "Regular", false),
            new Attendee("Lisa Davis", "lisa@example.com", "Premium", false),
            new Attendee("Tom Miller", "tom@example.com", "VIP", true),
            new Attendee("Amy Taylor", "amy@example.com", "Regular", false)
        );
        
        System.out.println("=== Tech Conference 2024 - Welcome Messages ===\n");
        
        // Basic welcome message for all attendees
        System.out.println("📧 Sending welcome messages to all attendees:");
        attendees.forEach(attendee -> {
            String welcomeMessage = generateWelcomeMessage(attendee);
            System.out.println("To: " + attendee.getEmail());
            System.out.println(welcomeMessage);
            System.out.println("----------------------------------------");
        });
        
        System.out.println("\n=== VIP Special Messages ===");
        
        // Special VIP welcome messages
        attendees.stream()
            .filter(Attendee::isVip)
            .forEach(vip -> {
                System.out.println("🌟 VIP SPECIAL MESSAGE");
                System.out.println("To: " + vip.getEmail());
                System.out.println("Dear " + vip.getName() + ",");
                System.out.println("Welcome to our exclusive VIP experience!");
                System.out.println("Your VIP lounge access is confirmed.");
                System.out.println("Enjoy complimentary refreshments and priority seating.");
                System.out.println("Best regards, Event Team");
                System.out.println("----------------------------------------");
            });
        
        System.out.println("\n=== Ticket Type Specific Messages ===");
        
        // Group by ticket type and send specific messages
        Map<String, List<Attendee>> attendeesByType = new HashMap<>();
        attendees.forEach(attendee -> {
            attendeesByType.computeIfAbsent(attendee.getTicketType(), k -> new ArrayList<>())
                          .add(attendee);
        });
        
        attendeesByType.forEach((ticketType, attendeeList) -> {
            System.out.println("📋 " + ticketType.toUpperCase() + " TICKET HOLDERS:");
            attendeeList.forEach(attendee -> 
                System.out.println("  ✉️  " + attendee.getName() + " (" + attendee.getEmail() + ")"));
            System.out.println();
        });
        
        // Send reminder messages
        System.out.println("=== Event Reminder Messages ===");
        attendees.forEach(attendee -> 
            System.out.println("📱 SMS to " + attendee.getName() + ": " +
                             "Event starts at 9 AM tomorrow. " +
                             "Your " + attendee.getTicketType() + " ticket is confirmed."));
        
        // Statistics
        System.out.println("\n=== Event Statistics ===");
        System.out.println("Total attendees: " + attendees.size());
        
        long vipCount = attendees.stream().filter(Attendee::isVip).count();
        System.out.println("VIP attendees: " + vipCount);
        
        attendeesByType.forEach((type, list) -> 
            System.out.println(type + " tickets: " + list.size()));
    }
    
    private static String generateWelcomeMessage(Attendee attendee) {
        StringBuilder message = new StringBuilder();
        message.append("Dear ").append(attendee.getName()).append(",\n");
        message.append("Welcome to Tech Conference 2024!\n");
        message.append("Your ").append(attendee.getTicketType()).append(" ticket is confirmed.\n");
        
        if (attendee.isVip()) {
            message.append("🌟 As a VIP guest, you have exclusive access to:\n");
            message.append("   • VIP Lounge\n");
            message.append("   • Priority Seating\n");
            message.append("   • Meet & Greet with Speakers\n");
        }
        
        message.append("Event Details:\n");
        message.append("📅 Date: Tomorrow, 9:00 AM\n");
        message.append("📍 Location: Convention Center\n");
        message.append("We look forward to seeing you!\n");
        message.append("Best regards,\nEvent Team");
        
        return message.toString();
    }
}