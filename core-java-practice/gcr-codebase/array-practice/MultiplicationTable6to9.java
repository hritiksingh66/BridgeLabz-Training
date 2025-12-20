import java.util.Scanner;

// Program to generate multiplication table from 6 to 9
public class MultiplicationTable6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store multiplication results for 6-9
        int[] multiplicationResult = new int[4];
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Generate multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        
        // Display multiplication table from 6 to 9
        System.out.println("\nMultiplication table from 6 to 9:");
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }
        
        sc.close();
    }
}
