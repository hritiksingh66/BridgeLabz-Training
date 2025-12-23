import java.util.Scanner;

public class NumberAnalyzer {
    public static boolean isPositive(int num) {
        return num > 0;
    }
    
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();
        }
        
        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < nums.length; i++) {
            if (isPositive(nums[i])) {
                if (isEven(nums[i])) {
                    System.out.println(nums[i] + " is positive and even");
                } else {
                    System.out.println(nums[i] + " is positive and odd");
                }
            } else {
                System.out.println(nums[i] + " is negative");
            }
        }
        
        int comparison = compare(nums[0], nums[4]);
        System.out.println("\nComparison of first and last elements:");
        if (comparison == 1) {
            System.out.println("First element (" + nums[0] + ") is greater than last element (" + nums[4] + ")");
        } else if (comparison == 0) {
            System.out.println("First element (" + nums[0] + ") is equal to last element (" + nums[4] + ")");
        } else {
            System.out.println("First element (" + nums[0] + ") is less than last element (" + nums[4] + ")");
        }
        
        scanner.close();
    }
}
