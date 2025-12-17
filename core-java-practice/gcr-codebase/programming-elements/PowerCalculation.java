import java.util.Scanner;

public class PowerCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take base input
        System.out.print("Enter base value: ");
        double b = sc.nextDouble();

        // Take exponent input
        System.out.print("Enter exponent value: ");
        double e = sc.nextDouble();

        // Calculate power using Math.pow()
        double res = Math.pow(b, e);

        // Print the result
        System.out.println("Result: " + res);

        sc.close();
    }
}

