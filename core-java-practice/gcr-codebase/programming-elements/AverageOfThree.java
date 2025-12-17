import java.util.Scanner;

public class AverageOfThree {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input of first number from user
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        // Taking input of second number from user
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        // Taking input of third number from user
        System.out.print("Enter third number: ");
        double c = sc.nextDouble();

        // Calculating average of three numbers
        double avg = (a + b + c) / 3;

        // Print the result
        System.out.println("Average of the three numbers is: " + avg);

        sc.close();
    }
}

