import java.util.Scanner;

public class RaviCafe {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String choice;
    double price = 0;
    final double GST = 0.05;

    while (true) {

      // MENU DISPLAY
      System.out.println("\n====== ☕ COFFEE MENU ☕ ======");
      System.out.println("1. Espresso    - INR 90");
      System.out.println("2. Latte       - INR 120");
      System.out.println("3. Cappuccino  - INR 150");
      System.out.println("Type coffee NAME or SERIAL NUMBER");
      System.out.println("Type 'exit' to stop");
      System.out.println("=============================");

      System.out.print("Your choice: ");
      choice = sc.next().toLowerCase();

      if (choice.equals("exit")) {
        System.out.println("Thank you! Visit again ☕");
        break;
      }

      System.out.print("Enter quantity: ");
      int quantity = sc.nextInt();

      switch (choice) {
        case "1":
        case "espresso":
          price = 120;
          break;

        case "2":
        case "latte":
          price = 150;
          break;

        case "3":
        case "cappuccino":
          price = 180;
          break;

        default:
          System.out.println("❌ Invalid selection!");
          continue;
      }

      // calculating total amount = amount + gstAmount
      double amnt = price * quantity;
      double gstAmnt = amnt * GST;
      double totalBill = amnt + gstAmnt;

      System.out.println("\n----- BILL DETAILS -----");
      System.out.println("Quantity   : " + quantity);
      System.out.println("Amount     : INR " + amnt);
      System.out.println("GST (5%)   : INR " + gstAmnt);
      System.out.println("Total Bill :  INR " + totalBill);
    }

    sc.close();
  }
}