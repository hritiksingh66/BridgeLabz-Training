import java.util.Scanner;

// Program to distribute chocolates among children using division
public class ChocolateDistribution {
    
    // Find quotient and remainder when dividing chocolates
    public static int[] findRemainderAndQuotient(int num, int divisor) {
        int quotient = num / divisor;
        int remainder = num % divisor;
        return new int[]{remainder, quotient};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter number of chocolates: ");
        int numOfChocolates = scanner.nextInt();
        
        System.out.print("Enter number of children: ");
        int numOfChildren = scanner.nextInt();
        
        // Calculate distribution
        int[] result = findRemainderAndQuotient(numOfChocolates, numOfChildren);
        
        // Display results
        System.out.println("Each child will get: " + result[1] + " chocolates");
        System.out.println("Remaining chocolates: " + result[0]);
        
        scanner.close();
    }
}
