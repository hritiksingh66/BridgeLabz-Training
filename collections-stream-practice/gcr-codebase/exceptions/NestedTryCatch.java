import java.util.Scanner;

public class NestedTryCatch {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            
            int[] array = new int[size];
            
            // Fill array
            System.out.println("Enter " + size + " numbers:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();
            
            try {
                // Inner try block for array access
                int element = array[index];
                
                try {
                    // Nested try block for division
                    int result = element / divisor;
                    System.out.println("Result: " + element + " / " + divisor + " = " + result);
                } catch (ArithmeticException e) {
                    // Handle division by zero
                    System.out.println("Cannot divide by zero!");
                }
                
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle invalid array index
                System.out.println("Invalid array index!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}