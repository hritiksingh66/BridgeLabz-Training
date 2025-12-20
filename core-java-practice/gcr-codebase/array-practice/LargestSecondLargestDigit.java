import java.util.Scanner;

// Program to find largest and second largest digit in a number
public class LargestSecondLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Initialize array to store digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        int tempNumber = number;
        
        // Extract digits from the number
        while (tempNumber != 0) {
            if (index == maxDigit) {
                break;  // Prevent array overflow
            }
            digits[index] = tempNumber % 10;
            tempNumber = tempNumber / 10;
            index++;
        }
        
        // Find largest and second largest digits
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // Display extracted digits
        System.out.print("Digits in the number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        
        // Display results
        System.out.println("\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        sc.close();
    }
}
