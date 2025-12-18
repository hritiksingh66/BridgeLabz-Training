public class ProfitLoss {

  public static void main(String[] args) {
    // Given Cost Price 
    int cp = 129;

    // given Selling Price
    int sp = 191;

    // Calculating profit = sp - cp 
    int profit = sp - cp ;

    // Calculating profit percentage using profit %age = profit 
    double profit_percent = ((double)profit / cp ) * 100;

    // Dispalying Cost Price and Selling Price  
    System.out.println("The cost price is INR "+cp + " and selling price is INR "+sp);

    // Displaying profit as number and profit percentage as result 
    System.out.printf("The profit is INR %d and the Profit Percentage is %.2f%%", 
                      profit, profit_percent);
  }
  
}
