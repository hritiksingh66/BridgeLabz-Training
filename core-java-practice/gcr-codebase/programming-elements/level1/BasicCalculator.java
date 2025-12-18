package level1;
import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Arithmetic operations
        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;

        // Printing results
        System.out.println(
            "The addition, subtraction, multiplication and division value of 2 numbers "
            + num1 + " and " + num2 + " is "
            + addition + ", "
            + subtraction + ", "
            + multiplication + ", and "
            + division
        );

        sc.close();
    }
}
