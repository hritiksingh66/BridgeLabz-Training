import java.util.*;

// Program to reverse a string using StringBuilder
public class ReverseString {
  // Main method to read input and reverse string
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Read input string
      String str = sc.nextLine();

      // Use StringBuilder to reverse the string
      StringBuilder sb = new StringBuilder(str);
      sb.reverse();
      System.out.println(sb.toString());
    }
  }
}