import java.util.Scanner;

public class DivisibleByFive {
  public static void main(String[] args) {

    // Create Scanner object for taking input from keyboard
    Scanner sc = new Scanner(System.in);

    // Taking input from user
    System.out.print("Enter a number: ");
    int number = sc.nextInt();

    // checking if divisible or not
    boolean isDivisible = (number % 5 == 0);

    // Displaying result
    System.out.println("Is the number " + number + " divisible by 5? " + (isDivisible ? "Yes" : "No"));

    sc.close();
  }
}
