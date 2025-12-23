import java.util.Scanner;

// Program to calculate Euclidean distance and line equation between two points
public class EuclideanDistanceAndLine {
    
    // Calculate Euclidean distance between two points
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
    
    // Find line equation (slope and y-intercept) for two points
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        // Handle vertical line case
        if (x2 == x1) {
            return new double[]{Double.POSITIVE_INFINITY, x1};
        }
        
        // Calculate slope and y-intercept
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        
        return new double[]{slope, yIntercept};
    }
    
    // Display line equation in readable format
    public static void displayLineEquation(double[] equation, double x1, double y1, double x2, double y2) {
        if (equation[0] == Double.POSITIVE_INFINITY) {
            System.out.println("Line Equation: x = " + equation[1]);
            System.out.println("This is a vertical line.");
        } else {
            double slope = equation[0];
            double yIntercept = equation[1];
            
            System.out.println("Line Equation Components:");
            System.out.println("Slope (m) = " + slope);
            System.out.println("Y-intercept (b) = " + yIntercept);
            
            // Format equation nicely
            System.out.print("Line Equation: y = ");
            if (slope == 1) {
                System.out.print("x");
            } else if (slope == -1) {
                System.out.print("-x");
            } else if (slope == 0) {
                System.out.print("0");
            } else {
                System.out.print(slope + "x");
            }
            
            if (yIntercept > 0) {
                System.out.println(" + " + yIntercept);
            } else if (yIntercept < 0) {
                System.out.println(" - " + Math.abs(yIntercept));
            } else {
                System.out.println();
            }
        }
    }
    
    // Display detailed analysis of two points
    public static void displayResults(double x1, double y1, double x2, double y2) {
        System.out.println("Point Analysis");
        System.out.println("==============");
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        System.out.println();
        
        // Calculate and show distance calculation steps
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance Calculation:");
        System.out.println("Formula: distance = √[(x2-x1)² + (y2-y1)²]");
        System.out.println("distance = √[(" + x2 + "-" + x1 + ")² + (" + y2 + "-" + y1 + ")²]");
        System.out.println("distance = √[(" + (x2-x1) + ")² + (" + (y2-y1) + ")²]");
        System.out.println("distance = √[" + Math.pow(x2-x1, 2) + " + " + Math.pow(y2-y1, 2) + "]");
        System.out.println("distance = √" + (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)));
        System.out.println("Euclidean Distance: " + distance);
        System.out.println();
        
        // Calculate and show line equation steps
        double[] equation = findLineEquation(x1, y1, x2, y2);
        
        if (equation[0] != Double.POSITIVE_INFINITY) {
            System.out.println("Line Equation Calculation:");
            System.out.println("Slope formula: m = (y2 - y1) / (x2 - x1)");
            System.out.println("m = (" + y2 + " - " + y1 + ") / (" + x2 + " - " + x1 + ")");
            System.out.println("m = " + (y2-y1) + " / " + (x2-x1));
            System.out.println("m = " + equation[0]);
            System.out.println();
            System.out.println("Y-intercept formula: b = y1 - m*x1");
            System.out.println("b = " + y1 + " - " + equation[0] + " * " + x1);
            System.out.println("b = " + y1 + " - " + (equation[0] * x1));
            System.out.println("b = " + equation[1]);
            System.out.println();
        }
        
        displayLineEquation(equation, x1, y1, x2, y2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Euclidean Distance and Line Equation Calculator");
        System.out.println("===============================================");
        System.out.println();
        
        // Get user input for two points
        System.out.print("Enter coordinates of first point (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        
        System.out.print("Enter coordinates of second point (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        
        // Analyze user input
        System.out.println();
        displayResults(x1, y1, x2, y2);
        
        // Test with sample points
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Testing with sample points (3, 4) and (6, 8):");
        displayResults(3, 4, 6, 8);
        
        scanner.close();
    }
}
