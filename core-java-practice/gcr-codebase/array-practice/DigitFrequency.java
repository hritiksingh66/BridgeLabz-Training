import java.util.Scanner;

// Program to find frequency of each digit in a number
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Count digits in the number
        int tempNumber = Math.abs(number);
        int digitCount = 0;
        
        if (tempNumber == 0) {
            digitCount = 1;
        } else {
            int temp = tempNumber;
            while (temp != 0) {
                digitCount++;
                temp = temp / 10;
            }
        }
        
        // Extract digits into array
        int[] digits = new int[digitCount];
        tempNumber = Math.abs(number);
        
        if (tempNumber == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < digitCount; i++) {
                digits[i] = tempNumber % 10;
                tempNumber = tempNumber / 10;
            }
        }
        
        // Count frequency of each digit (0-9)
        int[] frequency = new int[10];
        
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        // Display digits in original order
        System.out.print("Digits in the number: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        
        // Display frequency of each digit
        System.out.println("\n\nFrequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
        
        sc.close();
    }
}
