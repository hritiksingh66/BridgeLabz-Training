import java.util.Scanner;

public class TriangularParkRun {
    public static int calculateRounds(double side1, double side2, double side3, double targetDistance) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(targetDistance / perimeter);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first side of triangle (in meters): ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter second side of triangle (in meters): ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter third side of triangle (in meters): ");
        double side3 = scanner.nextDouble();
        
        double targetDistance = 5000;
        int rounds = calculateRounds(side1, side2, side3, targetDistance);
        
        double perimeter = side1 + side2 + side3;
        System.out.println("Perimeter of the triangular park: " + perimeter + " meters");
        System.out.println("Number of rounds needed to complete 5km run: " + rounds);
        
        scanner.close();
    }
}
