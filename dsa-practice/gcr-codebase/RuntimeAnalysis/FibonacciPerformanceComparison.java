// Performance comparison between recursive and iterative Fibonacci
public class FibonacciPerformanceComparison {
    
    // Recursive Fibonacci implementation
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Iterative Fibonacci implementation
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    
    // Main method to compare Fibonacci performance
    public static void main(String[] args) {
        int[] values = {10, 20, 30, 35};
        
        for (int n : values) {
            // Recursive approach
            long startTime = System.nanoTime();
            int recursiveResult = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            
            // Iterative approach
            startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            
            System.out.println("Fibonacci(" + n + "):");
            System.out.println("Recursive: " + recursiveResult + " - Time: " + (recursiveTime / 1_000_000.0) + " ms");
            System.out.println("Iterative: " + iterativeResult + " - Time: " + (iterativeTime / 1_000_000.0) + " ms");
            System.out.println("Speed improvement: " + (recursiveTime / (double) iterativeTime) + "x");
            System.out.println();
            
            // Stop recursive for large values to avoid timeout
            if (n >= 35) {
                System.out.println("Note: Recursive approach becomes unfeasible for n > 35");
                break;
            }
        }
    }
}