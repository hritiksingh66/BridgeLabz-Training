package Reflections;
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInspector {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter class name (e.g., java.lang.String): ");
        String className = sc.nextLine();
        
        try {
            // Get Class object
            Class<?> clazz = Class.forName(className);
         
            
            System.out.println("\n=== Class Information ===");
            System.out.println("Class Name: " + clazz.getName());
            
            // Display constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            
            // Display fields
            System.out.println("\n--- Fields ---");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            
            // Display methods
            System.out.println("\n--- Methods ---");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } finally {
            sc.close();
        }
    }
}

class Test {

    private String name;
    public int age;

    // Default constructor
    public Test() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void showName() {
        System.out.println("Name: " + name);
    }

    public void showAge() {
        System.out.println("Age: " + age);
    }
}
