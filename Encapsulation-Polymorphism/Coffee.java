import java.util.*;

// Simple coffee shop system - demonstrates basic programming concepts
public class Coffee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Display menu
		System.out.println("1. Coffee -> 80₹");
		System.out.println("2. Cold Coffee -> 100₹");
		System.out.println("3. Cappuccino -> 120₹");
		System.out.println("4. Exit");
		
		int quantity;
		
		// Main menu loop
		while(true) {
			System.out.print("What do you want to purchase: ");
			int choice = sc.nextInt();
			
			if(choice == 4) break; // Exit condition
			
			switch(choice) {
			case 1:
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				System.out.println("The Price is 80₹");
				calculateCoffeePrice(quantity);
				break;
				
			case 2:
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				System.out.println("The Price is 100₹");
				calculateColdCoffeePrice(quantity);
				break;
				
			case 3:
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				System.out.println("The Price is 120₹");
				calculateCappuccinoPrice(quantity);
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	
	// Method to calculate coffee price with tax
	static void calculateCoffeePrice(int quantity){
		int total = 80 * quantity;
		double totalWithTax = total + (total * 0.18); // 18% tax
		System.out.println("The Total Price is: " + totalWithTax);
	}
	
	// Method to calculate cold coffee price with tax
	static void calculateColdCoffeePrice(int quantity) {
		int total = 100 * quantity;
		double totalWithTax = total + (total * 0.18); // 18% tax
		System.out.println("The Total Price is: " + totalWithTax);
	}
	
	// Method to calculate cappuccino price with tax
	static void calculateCappuccinoPrice(int quantity) {
		int total = 120 * quantity; // Fixed price calculation
		double totalWithTax = total + (total * 0.18); // 18% tax
		System.out.println("The Total Price is: " + totalWithTax);
	}
}
