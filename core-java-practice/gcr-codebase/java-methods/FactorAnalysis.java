import java.util.Scanner;

// Program to analyze factors of a num with various calculations
public class FactorAnalysis {
    
    // Find all factors of a given num
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
    
    // Find the greatest factor
    public static int findGreatestFactor(int[] factors) {
        int greatest = factors[0];
        for (int factor : factors) {
            if (factor > greatest) {
                greatest = factor;
            }
        }
        return greatest;
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
    
    // Calculate product of cube of all factors
    public static double findProductOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number from user
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        // Find factors and perform analysis
        int[] factors = findFactors(num);
        
        // Display factors
        System.out.print("Factors of " + num + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
        
        // Display analysis results
        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + findSumOfFactors(factors));
        System.out.println("Product of factors: " + findProductOfFactors(factors));
        System.out.println("Product of cube of factors: " + findProductOfCubeOfFactors(factors));
        
        scanner.close();
    }
}
