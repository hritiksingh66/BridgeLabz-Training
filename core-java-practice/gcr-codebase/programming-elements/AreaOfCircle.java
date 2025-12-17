import java.util.Scanner;

public class AreaOfCircle {

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take radius input from user
        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();

        // Calculate area of the circle using formula π * r^2
        double area = Math.PI * r * r;

        // Print the result
        System.out.println("Area of the circle is: " + area);

        sc.close();
    }
}