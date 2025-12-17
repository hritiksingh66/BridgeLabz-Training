import java.util.Scanner;

public class SimpleInterest {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take principal amount from user
        System.out.print("Enter principal amount: ");
        double p = sc.nextDouble();

        // Take rate of interest from user
        System.out.print("Enter rate of interest: ");
        double r = sc.nextDouble();

        // Take time (in years) from user
        System.out.print("Enter time (in years): ");
        double t = sc.nextDouble();

        // Calculate simple interest using formula (P * R * T) / 100
        double si = (p * r * t) / 100;

        // Print the result
        System.out.println("Simple Interest is: " + si);

        sc.close();
    }
}

