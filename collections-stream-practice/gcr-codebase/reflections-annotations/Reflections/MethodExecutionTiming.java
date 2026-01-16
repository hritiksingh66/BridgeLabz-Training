package Reflections;
import java.lang.reflect.Method;

class DataProcessor {
    public void processSmallData() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Small data processed");
    }
    
    public void processLargeData() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Large data processed");
    }
    
    public int calculate(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }
}

public class MethodExecutionTiming {
    
    // Measure execution time of a method
    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName, paramTypes);
            
            // Start timer
            long startTime = System.nanoTime();
            
            // Invoke method
            Object result = method.invoke(obj, args);
            
            // End timer
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
            
            System.out.println("Method: " + methodName);
            if (result != null) {
                System.out.println("Result: " + result);
            }
            System.out.println("Execution time: " + duration + " ms\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        
        // Measure different methods
        measureExecutionTime(processor, "processSmallData", new Class[]{}, new Object[]{});
        measureExecutionTime(processor, "processLargeData", new Class[]{}, new Object[]{});
        measureExecutionTime(processor, "calculate", new Class[]{int.class}, new Object[]{1000000});
    }
}