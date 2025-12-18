package level1;
public class DiscountFee {

    public static void main(String[] args) {

        // Course fee
        int fee = 125000;

        // Discount percentage
        int discnt_percent = 10;

        // Calculate discount amount
        int discnt = (fee * discnt_percent) / 100;

        // Calculate final fee after discount
        int total_fee = fee - discnt;

        // Print the results
        System.out.println("The discount amount is INR " + discnt +
                " and final discounted fee is INR " + total_fee);
    }
}
