import java.util.Scanner;

public class NumberCheckerPalindrome {
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
    
    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    
    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigitsArray(digits);
        return compareArrays(digits, reversed);
    }
    
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int num = scanner.nextInt();
        
        int[] digits = storeDigits(num);
        int[] reversed = reverseDigitsArray(digits);
        
        System.out.println("Number of digits: " + findDigitCount(num));
        
        System.out.print("Original digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        System.out.print("Reversed digits: ");
        for (int digit : reversed) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        System.out.println("Arrays are equal: " + compareArrays(digits, reversed));
        System.out.println("Is Palindrome: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        
        scanner.close();
    }
}
