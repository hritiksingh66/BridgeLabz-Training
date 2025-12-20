import java.util.Scanner;

// Program to implement FizzBuzz game using arrays
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get positive integer from user
        System.out.print("Enter a positive Integer: ");
        int number = sc.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Please enter a positive integer");
            return;
        }
        
        // Array to store FizzBuzz results
        String[] results = new String[number + 1];

        // Generate FizzBuzz results
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";  // Divisible by both 3 and 5
            } else if (i % 3 == 0) {
                results[i] = "Fizz";      // Divisible by 3
            } else if (i % 5 == 0) {
                results[i] = "Buzz";      // Divisible by 5
            } else {
                results[i] = String.valueOf(i);  // Not divisible by 3 or 5
            }
        }

        // Display FizzBuzz results
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        sc.close();
    }
}
