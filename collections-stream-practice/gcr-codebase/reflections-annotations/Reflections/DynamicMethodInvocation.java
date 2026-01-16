package Reflections;
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            MathOperations math = new MathOperations();
            Class<?> clazz = math.getClass();
            
            System.out.print("Enter method name (add/subtract/multiply): ");
            String methodName = sc.nextLine();
            
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            
            // Get method dynamically
            Method method = clazz.getMethod(methodName, int.class, int.class);
            
            // Invoke method
            int result = (int) method.invoke(math, a, b);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}