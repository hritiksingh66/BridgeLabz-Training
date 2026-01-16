package Reflections;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
    String date() default "Unknown";
}

// Apply annotation to class
@Author(name = "John Doe", date = "2024-01-15")
class MyClass {
    public void display() {
        System.out.println("Hello from MyClass");
    }
}

public class RetrieveAnnotations {
    
    public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> clazz = MyClass.class;
            
            // Check if annotation is present
            if (clazz.isAnnotationPresent(Author.class)) {
                // Get annotation
                Author author = clazz.getAnnotation(Author.class);
                
                // Display annotation values
                System.out.println("Author Name: " + author.name());
                System.out.println("Date: " + author.date());
            } else {
                System.out.println("No @Author annotation found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}