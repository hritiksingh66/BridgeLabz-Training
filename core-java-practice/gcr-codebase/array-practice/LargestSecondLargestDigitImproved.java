import java.util.Scanner;

// Improved program to find largest and second largest digit with dynamic array
public class LargestSecondLargestDigitImproved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Initialize dynamic array for digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        int tempNumber = number;
        
        // Extract digits with dynamic array resizing
        while (tempNumber != 0) {
            // Resize array if needed
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int j = 0; j < digits.length; j++) {
                    temp[j] = digits[j];
                }
                digits = temp;
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
