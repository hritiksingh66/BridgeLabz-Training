import java.util.Scanner;

public class CelciusToFahren {

   // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take temperature in Celsius from user
        System.out.print("Enter temperature in Celsius: ");
        double cel = sc.nextDouble();

        // Convert Celsius to Fahrenheit
        double fahren = (cel * 9 / 5) + 32;

        // Print the result
        System.out.println("Temperature in Fahrenheit: " + fahren);

        sc.close();
    }
}