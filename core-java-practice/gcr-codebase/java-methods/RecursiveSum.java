import java.util.Scanner;

public class RecursiveSum {
    public static int findSumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n + findSumRecursive(n - 1);
    }
    
    public static int findSumFormula(int n) {
        return n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a natural number (positive integer)");
            return;
        }
        
        int recursiveSum = findSumRecursive(n);
        int formulaSum = findSumFormula(n);
        
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        
        if (recursiveSum == formulaSum) {
            System.out.println("Both results are correct and match!");
        } else {
            System.out.println("Results do not match!");
        }
        
        scanner.close();
    }
}
