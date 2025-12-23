import java.util.Scanner;

public class NumberCheckerAdvanced {
    public static int findSumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    
    public static boolean isPerfectNumber(int num) {
        if (num <= 1) return false;
        return findSumOfProperDivisors(num) == num;
    }
    
    public static boolean isAbundantNumber(int num) {
        if (num <= 1) return false;
        return findSumOfProperDivisors(num) > num;
    }
    
    public static boolean isDeficientNumber(int num) {
        if (num <= 1) return false;
        return findSumOfProperDivisors(num) < num;
    }
    
    public static int findFactorial(int n) {
        if (n <= 1) return 1;
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    public static boolean isStrongNumber(int num) {
        int sum = 0;
        int temp = Math.abs(num);
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += findFactorial(digit);
            temp /= 10;
        }
        
        return sum == num;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        int sumOfDivisors = findSumOfProperDivisors(num);
        
        System.out.println("Sum of proper divisors: " + sumOfDivisors);
        System.out.println("Is Perfect Number: " + isPerfectNumber(num));
        System.out.println("Is Abundant Number: " + isAbundantNumber(num));
        System.out.println("Is Deficient Number: " + isDeficientNumber(num));
        System.out.println("Is Strong Number: " + isStrongNumber(num));
        
        scanner.close();
    }
}
