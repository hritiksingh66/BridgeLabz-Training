// Program to demonstrate NullPointerException handling
public class NullPointerDemo {
    
    // Method that generates NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // Calling method on null reference
    }

    // Method that handles NullPointerException
    public static void handleException() {
        try {
            String text = null;
            System.out.println(text.length()); // Calling method on null reference
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }

    public static void main(String[] args) {
        // Test exception handling
        handleException();
    }
}
