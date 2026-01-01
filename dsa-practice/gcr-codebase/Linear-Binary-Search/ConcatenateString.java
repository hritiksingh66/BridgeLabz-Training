import java.util.Scanner;

// Program to concatenate strings using StringBuffer
public class ConcatenateString {
  // Main method to read strings and concatenate them
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Read number of strings
      int n = sc.nextInt();
      // Read strings into array
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.next();
      }

      // Concatenate all strings using StringBuffer
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < n; i++) {
        sb.append(arr[i]);
      }
      System.out.println(sb.toString());
    }
  }
}