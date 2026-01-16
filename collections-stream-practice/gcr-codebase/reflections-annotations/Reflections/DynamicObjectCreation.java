package Reflections;
import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int rollNo;
    
    public Student() {
        this.name = "Unknown";
        this.rollNo = 0;
    }
    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    
    @Override
    public String toString() {
        return "Student[name=" + name + ", rollNo=" + rollNo + "]";
    }
}

public class DynamicObjectCreation {
    
    public static void main(String[] args) {
        try {
            // Get Class object
            Class<?> clazz = Class.forName("Student");
            
            // Create object using default constructor
            Object obj1 = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Object 1: " + obj1);
            
            // Create object using parameterized constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            Object obj2 = constructor.newInstance("John", 101);
            System.out.println("Object 2: " + obj2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}