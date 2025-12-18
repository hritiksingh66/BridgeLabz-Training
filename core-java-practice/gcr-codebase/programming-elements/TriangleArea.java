import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input base and height in inches
        System.out.print("Enter base in inches: ");
        double base = sc.nextDouble();

        System.out.print("Enter height in inches: ");
        double height = sc.nextDouble();

        // Area in square inches
        double area_in_sq_inches = 0.5 * base * height;

        // Convert to square centimeters
        double area_in_sq_cm = area_in_sq_inches * 6.4516;

        // Output
        System.out.println("Area of Triangle:");
        System.out.println("In square inches: " + area_in_sq_inches);
        System.out.println("In square centimeters: " + area_in_sq_cm);

        sc.close();
    }
}
