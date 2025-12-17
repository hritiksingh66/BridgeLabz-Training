import java.util.Scanner;

public class PerimeterOfRectangle {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take length input from user
        System.out.print("Enter length of the rectangle: ");
        double l = sc.nextDouble();

        // Take width input from user
        System.out.print("Enter width of the rectangle: ");
        double w = sc.nextDouble();

        // Calculate perimeter using formula : 2 * (length + width)
        double p = 2 * (l + w);

        // Print the result
        System.out.println("Perimeter of the rectangle is: " + p);

        sc.close();
    }
}
