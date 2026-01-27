import java.util.*;
import java.util.function.Consumer;

public class SmartHomeLighting {
    
    // Light control interface using Consumer functional interface
    private Map<String, Consumer<String>> lightBehaviors = new HashMap<>();
    
    public SmartHomeLighting() {
        // Define different light behaviors using lambdas
        
        // Motion trigger - turn on bright lights
        lightBehaviors.put("motion", room -> 
            System.out.println("Motion detected in " + room + " - Turning on bright lights"));
        
        // Time-based trigger - dim lights for evening
        lightBehaviors.put("evening", room -> 
            System.out.println("Evening mode in " + room + " - Setting dim warm lights"));
        
        // Voice command trigger - toggle lights
        lightBehaviors.put("voice", room -> 
            System.out.println("Voice command received for " + room + " - Toggling lights"));
        
        // Morning trigger - gradual brightness increase
        lightBehaviors.put("morning", room -> 
            System.out.println("Morning routine in " + room + " - Gradually increasing brightness"));
    }
    
    // Execute light behavior based on trigger type
    public void activateLights(String trigger, String room) {
        Consumer<String> behavior = lightBehaviors.get(trigger);
        if (behavior != null) {
            behavior.accept(room);
        } else {
            System.out.println("Unknown trigger: " + trigger);
        }
    }
    
    public static void main(String[] args) {
        SmartHomeLighting smartHome = new SmartHomeLighting();
        
        // Test different triggers
        smartHome.activateLights("motion", "Living Room");
        smartHome.activateLights("evening", "Bedroom");
        smartHome.activateLights("voice", "Kitchen");
        smartHome.activateLights("morning", "Bathroom");
    }
}