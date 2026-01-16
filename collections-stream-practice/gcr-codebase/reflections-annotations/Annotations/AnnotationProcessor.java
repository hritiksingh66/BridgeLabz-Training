package Annotations;

import java.lang.reflect.Method;

class ValidationService {
    
    @ValidateInput(min = 18, max = 65, message = "Age must be between 18 and 65")
    public void setAge(int age) {
        System.out.println("Age set to: " + age);
    }
    
    @ValidateInput(min = 1000, max = 100000, message = "Salary must be between 1000 and 100000")
    public void setSalary(int salary) {
        System.out.println("Salary set to: " + salary);
    }
}

public class AnnotationProcessor {
    
    // Process @ValidateInput annotation
    public static boolean validateMethod(Object obj, String methodName, int value) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, int.class);
            
            if (method.isAnnotationPresent(ValidateInput.class)) {
                ValidateInput validate = method.getAnnotation(ValidateInput.class);
                
                // Check validation rules
                if (value < validate.min() || value > validate.max()) {
                    System.out.println("Validation failed: " + validate.message());
                    return false;
                }
            }
            
            // Invoke method if validation passes
            method.invoke(obj, value);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        ValidationService service = new ValidationService();
        
        System.out.println("=== Testing Validation ===\n");
        
        // Valid age
        validateMethod(service, "setAge", 25);
        
        // Invalid age (too young)
        validateMethod(service, "setAge", 15);
        
        // Invalid age (too old)
        validateMethod(service, "setAge", 70);
        
        System.out.println();
        
        // Valid salary
        validateMethod(service, "setSalary", 50000);
        
        // Invalid salary (too low)
        validateMethod(service, "setSalary", 500);
    }
}