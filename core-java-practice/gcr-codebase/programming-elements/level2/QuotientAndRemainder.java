package level2;

import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Calculate quotient and remainder
        int quotient = num1 / num2;
        int remainder = num1 % num2;

        // Output
        System.out.println("The Quotient is " + quotient +
                " and Reminder is " + remainder +
                " of two number " + num1 + " and " + num2);

        sc.close();
    }
}
