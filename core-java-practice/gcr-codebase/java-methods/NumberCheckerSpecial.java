import java.util.Scanner;

public class NumberCheckerSpecial {
    public static boolean isPrimeNumber(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNeonNumber(int num) {
        int square = num * num;
        int sum = 0;
        
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        
        return sum == num;
    }
    
    public static boolean isSpyNumber(int num) {
        int sum = 0;
        int product = 1;
        int temp = Math.abs(num);
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        return sum == product;
    }
    
    public static boolean isAutomorphicNumber(int num) {
        int square = num * num;
        int temp = num;
        
        while (temp > 0) {
            if (square % 10 != temp % 10) {
                return false;
            }
            square /= 10;
            temp /= 10;
        }
        
        return true;
    }
    
    public static boolean isBuzzNumber(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        System.out.println("Is Prime Number: " + isPrimeNumber(num));
        System.out.println("Is Neon Number: " + isNeonNumber(num));
        System.out.println("Is Spy Number: " + isSpyNumber(num));
        System.out.println("Is Automorphic Number: " + isAutomorphicNumber(num));
        System.out.println("Is Buzz Number: " + isBuzzNumber(num));
        
        scanner.close();
    }
}
