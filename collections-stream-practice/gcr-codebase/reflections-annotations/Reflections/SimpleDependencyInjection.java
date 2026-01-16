package Reflections;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

// Custom @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Service classes
class DatabaseService {
    public void connect() {
        System.out.println("Database connected");
    }
}

class EmailService {
    public void sendEmail(String to) {
        System.out.println("Email sent to: " + to);
    }
}

// Class with dependencies
class UserService {
    @Inject
    private DatabaseService dbService;
    
    @Inject
    private EmailService emailService;
    
    public void registerUser(String email) {
        dbService.connect();
        System.out.println("User registered");
        emailService.sendEmail(email);
    }
}

// Simple DI Container
class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();
    
    // Register dependencies
    public void register(Class<?> clazz) throws Exception {
        instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
    }
    
    // Inject dependencies
    public <T> T getInstance(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        
        // Find fields with @Inject annotation
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                
                // Get or create dependency
                Object dependency = instances.get(field.getType());
                if (dependency == null) {
                    dependency = field.getType().getDeclaredConstructor().newInstance();
                    instances.put(field.getType(), dependency);
                }
                
                // Inject dependency
                field.set(instance, dependency);
            }
        }
        
        return instance;
    }
}

public class SimpleDependencyInjection {
    
    public static void main(String[] args) {
        try {
            DIContainer container = new DIContainer();
            
            // Register services
            container.register(DatabaseService.class);
            container.register(EmailService.class);
            
            // Get UserService with injected dependencies
            UserService userService = container.getInstance(UserService.class);
            
            // Use service
            userService.registerUser("user@example.com");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}