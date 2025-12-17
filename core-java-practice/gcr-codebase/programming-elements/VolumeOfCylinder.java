import java.util.Scanner;

public class VolumeOfCylinder {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take radius input from user
        System.out.print("Enter radius of the cylinder: ");
        double r = sc.nextDouble();

        // Take height input from user
        System.out.print("Enter height of the cylinder: ");
        double h = sc.nextDouble();

        // Calculate volume using formula: π * r^2 * h
        double volume = Math.PI * r * r * h;

        // Print the result
        System.out.println("Volume of the cylinder is: " + volume);

        sc.close();
    }
}

