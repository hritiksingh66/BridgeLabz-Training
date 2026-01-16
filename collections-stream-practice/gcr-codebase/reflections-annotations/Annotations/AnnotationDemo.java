package Annotations;

import java.lang.reflect.Method;

// Example class using custom annotations
@Author(name = "John Doe", date = "2024-01-15", version = "2.0")
class AnnotatedService {
    
    @Loggable(value = "DEBUG", logParams = true, logResult = true)
    @ValidateInput(min = 1, max = 100, message = "Value must be between 1 and 100")
    public int processData(int value) {
        return value * 2;
    }
    
    @DeprecatedAPI(since = "2.0", replacement = "newMethod()", reason = "Use newMethod for better performance")
    public void oldMethod() {
        System.out.println("This is deprecated");
    }
    
    @Transactional(readOnly = false, timeout = 60)
    public void saveData(String data) {
        System.out.println("Saving: " + data);
    }
}

public class AnnotationDemo {
    
    public static void main(String[] args) {
        try {
            Class<?> clazz = AnnotatedService.class;
            
            // Check class-level annotations
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("=== Class Annotations ===");
                System.out.println("Author: " + author.name());
                System.out.println("Date: " + author.date());
                System.out.println("Version: " + author.version());
            }
            
            // Check method-level annotations
            System.out.println("\n=== Method Annotations ===");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("\nMethod: " + method.getName());
                
                if (method.isAnnotationPresent(Loggable.class)) {
                    Loggable log = method.getAnnotation(Loggable.class);
                    System.out.println("  @Loggable: level=" + log.value() + 
                                     ", logParams=" + log.logParams());
                }
                
                if (method.isAnnotationPresent(ValidateInput.class)) {
                    ValidateInput validate = method.getAnnotation(ValidateInput.class);
                    System.out.println("  @ValidateInput: min=" + validate.min() + 
                                     ", max=" + validate.max());
                }
                
                if (method.isAnnotationPresent(DeprecatedAPI.class)) {
                    DeprecatedAPI deprecated = method.getAnnotation(DeprecatedAPI.class);
                    System.out.println("  @DeprecatedAPI: since=" + deprecated.since() + 
                                     ", replacement=" + deprecated.replacement());
                }
                
                if (method.isAnnotationPresent(Transactional.class)) {
                    Transactional tx = method.getAnnotation(Transactional.class);
                    System.out.println("  @Transactional: readOnly=" + tx.readOnly() + 
                                     ", timeout=" + tx.timeout());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}