import java.util.Scanner;

// Program to check if three points are collinear using slope and area methods
public class CollinearPoints {
    
    // Check collinearity using slope comparison
    public static boolean isCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Handle vertical lines
        if (x2 == x1 && x3 == x2) {
            return true;
        }
        
        // Handle mixed vertical and non-vertical lines
        if (x2 == x1 || x3 == x2 || x3 == x1) {
            if (x2 == x1 && x3 != x1) return false;
            if (x3 == x2 && x1 != x2) return false;
            if (x3 == x1 && x2 != x1) return false;
            return true;
        }
        
        // Calculate slopes between all pairs
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        
        // Check if all slopes are equal (with tolerance for floating point)
        return Math.abs(slopeAB - slopeBC) < 1e-9 && 
               Math.abs(slopeBC - slopeAC) < 1e-9 && 
               Math.abs(slopeAB - slopeAC) < 1e-9;
    }
    
    // Check collinearity using triangle area (should be 0 for collinear points)
    public static boolean isCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) < 1e-9;
    }
    
    // Calculate slope between two points
    public static double calculateSlope(double x1, double y1, double x2, double y2) {
        if (x2 == x1) {
            return Double.POSITIVE_INFINITY; // Vertical line
        }
        return (y2 - y1) / (x2 - x1);
    }
    
    // Calculate area of triangle formed by three points
    public static double calculateTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }
    
    // Display detailed analysis results
    public static void displayResults(double x1, double y1, double x2, double y2, double x3, double y3) {
        System.out.println("Points: A(" + x1 + ", " + y1 + "), B(" + x2 + ", " + y2 + "), C(" + x3 + ", " + y3 + ")");
        
        // Calculate slopes
        double slopeAB = calculateSlope(x1, y1, x2, y2);
        double slopeBC = calculateSlope(x2, y2, x3, y3);
        double slopeAC = calculateSlope(x1, y1, x3, y3);
        
        // Display slope analysis
        System.out.println("\nSlope Analysis:");
        if (slopeAB == Double.POSITIVE_INFINITY) {
            System.out.println("Slope AB: Undefined (vertical line)");
        } else {
            System.out.println("Slope AB: " + slopeAB);
        }
        
        if (slopeBC == Double.POSITIVE_INFINITY) {
            System.out.println("Slope BC: Undefined (vertical line)");
        } else {
            System.out.println("Slope BC: " + slopeBC);
        }
        
        if (slopeAC == Double.POSITIVE_INFINITY) {
            System.out.println("Slope AC: Undefined (vertical line)");
        } else {
            System.out.println("Slope AC: " + slopeAC);
        }
        
        // Calculate and display triangle area
        double area = calculateTriangleArea(x1, y1, x2, y2, x3, y3);
        System.out.println("\nTriangle Area: " + area);
        
        // Check collinearity using both methods
        boolean collinearBySlope = isCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        boolean collinearByArea = isCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        
        // Display results
        System.out.println("\nResults:");
        System.out.println("Collinear by Slope Method: " + collinearBySlope);
        System.out.println("Collinear by Area Method: " + collinearByArea);
        
        if (collinearBySlope && collinearByArea) {
            System.out.println("Conclusion: The three points are COLLINEAR");
        } else {
            System.out.println("Conclusion: The three points are NOT COLLINEAR");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test with sample points
        System.out.println("Testing sample points A(2, 4), B(4, 6), C(6, 8):");
        displayResults(2, 4, 4, 6, 6, 8);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Enter your own three points:");
        
        // Get user input for three points
        System.out.print("Enter coordinates of point A (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        
        System.out.print("Enter coordinates of point B (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        
        System.out.print("Enter coordinates of point C (x3 y3): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        
        // Analyze user input points
        System.out.println();
        displayResults(x1, y1, x2, y2, x3, y3);
        
        scanner.close();
    }
}
