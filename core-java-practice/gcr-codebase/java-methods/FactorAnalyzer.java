import java.util.Scanner;

// Program to analyze factors with sum, product and sum of squares
public class FactorAnalyzer {
    
    // Find all factors of a given number
    public static int[] findFactors(int num) {
        // Count factors first
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        
        // Store factors in array
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }
    
    // Calculate sum of all factors
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }
    
    // Calculate product of all factors
    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    
    // Calculate sum of squares of all factors
    public static double findSumOfSquareOfFactors(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        // Find factors
        int[] factors = findFactors(num);
        
        // Display factors
        System.out.print("Factors of " + num + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        
        // Calculate and display analysis results
        int sum = findSumOfFactors(factors);
        long product = findProductOfFactors(factors);
        double sumOfSquares = findSumOfSquareOfFactors(factors);
        
        System.out.println("\nSum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of square of factors: " + sumOfSquares);
        
        scanner.close();
    }
}
