package level1;
import java.util.Scanner;

public class HeightConverter {

    public static void main(String[] args) {

        // Creating Scanner object to take input from keyboard
        Scanner sc = new Scanner(System.in);

        // Taking user input for height in centimeters
        System.out.print("Enter your height in centimeters: ");
        double height = sc.nextDouble();

        // Convert centimeters to inches
        // 1 inch = 2.54 cm
        double total_inches = height / 2.54;

        // Calculate feet
        int feet = (int) (total_inches / 12);

        // Calculate remaining inches
        double inches = total_inches % 12;

        // Round inches to 2 decimal places
        inches = Math.round(inches * 100.0) / 100.0;

        // Print the result
        System.out.println("Your Height in cm is " + height +
                " while in feet is " + feet +
                " and inches is " + inches);

        // Close the Scanner
        sc.close();
    }
}
