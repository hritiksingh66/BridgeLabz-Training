import java.util.Scanner;

// Program to generate multiplication table using arrays
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store multiplication table results
        int[] multiplicationTable = new int[10];
        
        // Get number from user
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = sc.nextInt();
        
        // Generate multiplication table (1 to 10)
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }
        
        // Display multiplication table
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
        
        sc.close();
    }
}
