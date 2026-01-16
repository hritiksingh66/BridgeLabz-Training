package Reflections;

import java.lang.reflect.Field;

class Person {
    private int age = 25; // Private field
    
    public Person() {}
}

public class AccessPrivateField {
    
    public static void main(String[] args) {
        try {
            // Create Person object
            Person person = new Person();
            
            // Get Class object
            Class<?> clazz = person.getClass();
            
            // Access private field
            Field ageField = clazz.getDeclaredField("age");
            
            // Make field accessible
            ageField.setAccessible(true);
            
            // Get current value
            int currentAge = (int) ageField.get(person);
            System.out.println("Current age: " + currentAge);
            
            // Modify value
            ageField.set(person, 30);
            System.out.println("Modified age: " + ageField.get(person));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}