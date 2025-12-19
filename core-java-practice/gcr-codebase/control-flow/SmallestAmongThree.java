import java.util.Scanner;

public class SmallestAmongThree {
    public static void main(String[] args) {

      // Creating scanner class object for taking input from keyboard
        Scanner sc = new Scanner(System.in);
        
        // Taking three numbers as input from user
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();
        
        // Checking whether first number is smallest or not
        boolean isFirstSmallest = (num1 <= num2 && num1 <= num3);
        
        // Displaying the result
        System.out.println("Is the first number the smallest? " + (isFirstSmallest ? "Yes" : "No"));
        
        sc.close();
    }
}