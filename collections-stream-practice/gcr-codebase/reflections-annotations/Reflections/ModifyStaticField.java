package Reflections;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "default-key-12345";
    
    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    
    public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> clazz = Configuration.class;
            
            // Get static field
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            
            // Make field accessible
            apiKeyField.setAccessible(true);
            
            // Get current value (pass null for static fields)
            String currentKey = (String) apiKeyField.get(null);
            System.out.println("Current API_KEY: " + currentKey);
            
            // Modify static field value
            apiKeyField.set(null, "new-secret-key-67890");
            
            // Verify modification
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}