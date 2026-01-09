import java.util.Scanner;

public class MultipleCatchBlocks {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            
            int[] array = new int[size];
            
            // Fill array with user input
            System.out.println("Enter " + size + " numbers:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            
            // Access array element
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handle null array
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            // Handle any other exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}