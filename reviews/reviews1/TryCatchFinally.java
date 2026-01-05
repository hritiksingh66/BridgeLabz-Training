package reviews.reviews1;
public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println("Division by Zero ");
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        

        System.out.println("Array Index ");
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Element: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds");
        } finally {
            System.out.println("Cleanup operations here");
        }
        
        System.out.println("No Exception ");
        try {
            int result = 20 / 4;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("This won't execute");
        } finally {
            System.out.println("Finally executes even without exception");
        }
    }
}