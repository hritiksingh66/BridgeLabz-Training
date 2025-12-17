import java.util.Scanner;

public class Palindrome {

    // Method to check whether a number is palindrome
    public static boolean isPalindrome(int x) {

        // Store original number
        int temp = x;

        // This will store the reversed number
        int formedNo = 0;

        // Loop to reverse the number
        while (x > 0) {

            // Get last digit and add it to formed number
            formedNo = (formedNo * 10) + (x % 10);

            // Remove last digit from x
            x = x / 10;
        }

        // Check if original number equals reversed number
        return temp == formedNo;
    }

    // Main method for user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        // Calling palindrome check method
        boolean result = isPalindrome(x);

        // Displaying result
        if (result) {
            System.out.println("The number is a Palindrome");
        } else {
            System.out.println("The number is NOT a Palindrome");
        }

        sc.close();
    }
}
