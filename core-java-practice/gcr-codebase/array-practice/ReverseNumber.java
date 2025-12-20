import java.util.Scanner;

// Program to reverse a number using arrays
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Count digits in the number
        int tempNumber = number;
        int digitCount = 0;
        
        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }
        
        // Extract digits into array
        int[] digits = new int[digitCount];
        tempNumber = number;
        
        for (int i = 0; i < digitCount; i++) {
            digits[i] = tempNumber % 10;
            tempNumber = tempNumber / 10;
        }
        
        // Create reversed digits array
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        // Display original number and digits
        System.out.print("Original number: " + number);
        System.out.print("\nDigits in original order: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        
        // Display reversed number
        System.out.print("\nReversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        
        sc.close();
    }
}
