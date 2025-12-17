import java.util.Scanner;

public class ReverseInteger {

  // Main method for taking Input
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking integer x as input from user
    System.out.print("Enter an integer (x): ");
    int x = sc.nextInt();

    // Creating object of ReverseInteger class
    ReverseInteger obj = new ReverseInteger();

    // Calling solve function
    int res = obj.solve(x);
  
    // Displaying the result
    System.out.println("The reversed integer is "+res);

    sc.close();
  }

  // Method for reversing Integer
  private int solve(int x) {

    // This will store the reversed number
    int revNo = 0;

    // Loop runs until all digits of x are processed
    while (x != 0) {

      // Get the last digit of the number
      int lastDigit = x % 10;

      // Check for overflow or underflow
      // If reversing goes out of int range, return 0
      if (revNo > Integer.MAX_VALUE / 10 || revNo < Integer.MIN_VALUE / 10)
        return 0;

      // Add last digit to the reversed number
      revNo = (revNo * 10) + lastDigit;

      // Remove the last digit from x
      x = x / 10;
    }

    // Return the reversed number
    return revNo;
  }
}
