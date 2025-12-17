import java.util.Scanner;

public class Power {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking base value input from user
    System.out.print("Enter the base (x):  ");
    double x = sc.nextDouble();

    // Taking input of power value from user
    System.out.print("Enter the exponent  (n):  ");
    long n = sc.nextLong();

    // Creating object of Solution class
    Power obj = new Power();

    // Calling solve function
    double result = obj.solve(x, n);

    // Displaying the result
    System.out.println("Result: " + result);

    sc.close();
  }

  // Function to calculate x raised to the power n (x^n)
  private double solve(double x, long n) {

    // Base case: anything raised to power 0 is 1
    if (n == 0)
      return 1;

    // If power is negative, convert it to positive
    // x^-n = 1 / (x^n)
    if (n < 0)
      return solve(1 / x, -n);

    // If n is even, square x and reduce power by half
    if (n % 2 == 0) {
      return solve(x * x, n / 2);
    }

    // If n is odd, multiply x once and reduce power
    return x * solve(x * x, (n - 1) / 2);

  }

}
