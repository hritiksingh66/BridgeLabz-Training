package level1;
import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input unit price
        System.out.print("Enter unit price (INR): ");
        double unit_price = sc.nextDouble();

        // Input quantity
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Calculate total price
        double total_price = unit_price * quantity;

        // Displaying output
        System.out.println("The total purchase price is INR " + total_price +
                " if the quantity " + quantity +
                " and unit price is INR " + unit_price);

        sc.close();
    }
}

