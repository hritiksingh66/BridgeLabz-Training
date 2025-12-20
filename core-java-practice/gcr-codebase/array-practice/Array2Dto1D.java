import java.util.Scanner;

// Program to convert 2D array to 1D array
public class Array2Dto1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get dimensions from user
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        
        // Create 2D array
        int[][] matrix = new int[rows][columns];
        
        // Input elements into 2D array
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Create 1D array with total size
        int[] array = new int[rows * columns];
        int index = 0;
        
        // Convert 2D to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        
        // Display 2D array
        System.out.println("\n2D Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Display 1D array
        System.out.print("\n1D Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        sc.close();
    }
}
