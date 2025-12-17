import java.util.Scanner;

public class AddTwoNumbers {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first number from user
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        // Take second number from user
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Add the two numbers
        int sum = num1 + num2;

        // Print the result
        System.out.println("Sum of the two numbers is: " + sum);

        sc.close();
    }
}