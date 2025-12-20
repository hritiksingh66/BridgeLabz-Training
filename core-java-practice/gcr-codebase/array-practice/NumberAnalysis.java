import java.util.Scanner;

// Program to analyze numbers and compare first and last elements
public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array to store 5 numbers
        int[] numbers = new int[5];
        
        // Input 5 numbers from user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        
        // Analyze each number (positive/negative, even/odd)
        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even");
                } else {
                    System.out.println(numbers[i] + " is positive and odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative");
            } else {
                System.out.println(numbers[i] + " is zero");
            }
        }
        
        // Compare first and last elements
        System.out.println("\nComparison of first and last elements:");
        if (numbers[0] == numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is equal to last element (" + numbers[4] + ")");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is greater than last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than last element (" + numbers[4] + ")");
        }
        
        sc.close();
    }
}
