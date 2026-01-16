package Reflections;
import java.lang.reflect.Field;
import java.util.*;

class User {
    private String name;
    private int age;
    private String email;
    
    @Override
    public String toString() {
        return "User[name=" + name + ", age=" + age + ", email=" + email + "]";
    }
}

public class CustomObjectMapper {
    
    // Map properties to object fields using reflection
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create new instance
        T obj = clazz.getDeclaredConstructor().newInstance();
        
        // Iterate through properties
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                // Get field by name
                Field field = clazz.getDeclaredField(entry.getKey());
                
                // Make field accessible
                field.setAccessible(true);
                
                // Set field value
                field.set(obj, entry.getValue());
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found: " + entry.getKey());
            }
        }
        
        return obj;
    }
    
    public static void main(String[] args) {
        try {
            // Create property map
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "Alice");
            properties.put("age", 28);
            properties.put("email", "alice@example.com");
            
            // Convert map to User object
            User user = toObject(User.class, properties);
            System.out.println("Created object: " + user);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}