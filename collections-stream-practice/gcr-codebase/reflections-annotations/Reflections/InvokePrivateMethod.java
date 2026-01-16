package Reflections;
import java.lang.reflect.Method;

class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    
    public static void main(String[] args) {
        try {
            // Create Calculator object
            Calculator calc = new Calculator();
            
            // Get Class object
            Class<?> clazz = calc.getClass();
            
            // Get private method
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            
            // Make method accessible
            multiplyMethod.setAccessible(true);
            
            // Invoke method
            int result = (int) multiplyMethod.invoke(calc, 5, 3);
            System.out.println("Result of multiply(5, 3): " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}