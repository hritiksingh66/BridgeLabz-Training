import java.util.Scanner;

public class DistanceConversion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input distance in feet
        System.out.print("Enter distance in feet: ");
        double dist_in_feet = sc.nextDouble();

        // Convert to yards and miles
        double dist_in_yards = dist_in_feet / 3;
        double dist_in_miles = dist_in_yards / 1760;

        // Displaying output
        System.out.println("Distance in yards is " + dist_in_yards +
                " and distance in miles is " + dist_in_miles);

        sc.close();
    }
}

