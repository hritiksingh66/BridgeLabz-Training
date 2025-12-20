import java.util.Scanner;

// Program to separate odd and even numbers from 1 to N
public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get positive number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Validate input
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (positive integer)");
            return;
        }
        
        // Arrays to store even and odd numbers
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;
        
        // Separate numbers from 1 to N into even and odd
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        
        // Display even numbers
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        
        // Display odd numbers
        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        
        sc.close();
    }
}
