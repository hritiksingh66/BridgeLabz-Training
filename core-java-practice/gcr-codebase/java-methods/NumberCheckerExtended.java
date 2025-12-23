import java.util.Scanner;

public class NumberCheckerExtended {
    public static int findDigitCount(int num) {
        if (num == 0) return 1;
        int count = 0;
        num = Math.abs(num);
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
    public static int[] storeDigits(int num) {
        int digitCount = findDigitCount(num);
        int[] digits = new int[digitCount];
        num = Math.abs(num);
        
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
    
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    
    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    
    public static boolean isHarshadNumber(int[] digits) {
        int originalNumber = 0;
        for (int digit : digits) {
            originalNumber = originalNumber * 10 + digit;
        }
        
        int sumOfDigits = findSumOfDigits(digits);
        return originalNumber % sumOfDigits == 0;
    }
    
    public static int[][] findDigitFrequency(int[] digits) {
        int[] frequency = new int[10];
        
        for (int digit : digits) {
            frequency[digit]++;
        }
        
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }
        
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                result[index][0] = i;
                result[index][1] = frequency[i];
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        int[] digits = storeDigits(num);
        
        System.out.println("Number of digits: " + findDigitCount(num));
        
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        System.out.println("Sum of digits: " + findSumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + findSumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(digits));
        
        int[][] frequency = findDigitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + frequency[i][0] + ": " + frequency[i][1] + " times");
        }
        
        scanner.close();
    }
}
