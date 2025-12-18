import java.util.Scanner;

public class KmIntoMiles {

    public static void main(String[] args) {

        // Creating Scanner object to take input from keyboard
        Scanner sc = new Scanner(System.in);

        // Declaring variable for kilometers
        double km;

        // Taking user input for kilometers
        System.out.print("Enter distance in kilometers: ");
        km = sc.nextInt();

        // Convert kilometers to miles using formula
        // 1 mile = 1.6 km
        double miles = km / 1.6;

        // Display the result
        System.out.println("The total miles is " + miles +
                " mile for the given " + km + " km");

        // Close the scanner
        sc.close();
    }
}
