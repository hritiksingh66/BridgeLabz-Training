import java.util.*;
import java.util.Scanner;
import java.util.HashSet;

// Program to remove duplicate characters from string
public class RemoveDuplicates {

  // Main method to read string and remove duplicates
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Read input string
      String str = sc.nextLine();

      // Use StringBuilder and HashSet to remove duplicates
      StringBuilder sb = new StringBuilder("");
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (!set.contains(ch)) {
          set.add(ch);
          sb.append(ch);
        }
      }

      System.out.println(sb.toString());
    }
  }

}
