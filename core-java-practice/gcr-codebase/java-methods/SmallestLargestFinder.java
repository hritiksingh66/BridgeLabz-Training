import java.util.Scanner;

public class SmallestLargestFinder {
    public static int[] findSmallestAndLargest(int num1, int num2, int num3) {
        int smallest = num1;
        int largest = num1;
        
        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }
        
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        
        return new int[]{smallest, largest};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();
        
        int[] result = findSmallestAndLargest(num1, num2, num3);
        
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
        
        scanner.close();
    }
}
