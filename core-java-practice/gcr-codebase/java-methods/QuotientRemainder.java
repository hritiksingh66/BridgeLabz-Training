import java.util.Scanner;

public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int num, int divisor) {
        int quotient = num / divisor;
        int remainder = num % divisor;
        return new int[]{remainder, quotient};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
        
        int[] result = findRemainderAndQuotient(num, divisor);
        
        System.out.println("Quotient: " + result[1]);
        System.out.println("Remainder: " + result[0]);
        
        scanner.close();
    }
}
