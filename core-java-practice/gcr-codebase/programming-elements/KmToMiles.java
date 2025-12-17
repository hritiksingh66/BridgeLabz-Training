import java.util.Scanner;

public class KmToMiles {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input of distance in kilometers from user
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();

        // Converting kilometers to miles using given formula
        double miles = km * 0.621371;

        // Print the result
        System.out.println("Distance in miles: " + miles);

        sc.close();
    }
}
