import java.util.Scanner;

public class FeeDiscountUserInput {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Take user input for fee
        System.out.print("Enter student fee (INR): ");
        double fee = sc.nextDouble();

        // Take user input for discount percentage
        System.out.print("Enter discount percentage: ");
        double discountPercent = sc.nextDouble();

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculate final fee after discount
        double totalFee = fee - discount;

        // Print the result
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + totalFee);

        // Close scanner
        sc.close();
    }
}

