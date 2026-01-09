public class ExceptionPropagation {
    
    public static void main(String[] args) {
        try {
            // Call method2 which calls method1
            method2();
        } catch (ArithmeticException e) {
            // Handle exception propagated from method1
            System.out.println("Handled exception in main");
        }
    }
    
    // Method that calls method1 (propagates exception)
    public static void method2() {
        System.out.println("Inside method2");
        method1(); // Exception propagates from here
    }
    
    // Method that throws ArithmeticException
    public static void method1() {
        System.out.println("Inside method1");
        // This will throw ArithmeticException
        int result = 10 / 0;
    }
}